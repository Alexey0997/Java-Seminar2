import java.io.*;

/*
* . Дана json строка (можно сохранить в файл и читать из файла)
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: * Студент [фамилия] получил [оценка] по предмету [предмет].
Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
 */
public class Sem_2_Hmw_Task3 {

    // ВЫЗОВ ФУНКЦИЙ
    public static void main(String[] args) throws IOException {
        StringBuilder s = input_str();                    // Вызов метода формирования строки.
        create_file(s);                                   // Вызов метода создания лог-файла и обработки исключений.
        read_file();
    }

    // МЕТОД ФОРМИРОВАНИЯ СТРОКИ ДЛЯ ЗАПИСИ В ФАЙЛ
    public static StringBuilder input_str() {
        StringBuilder data_string = new StringBuilder();
        String jsonString = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        data_string.append(jsonString);
        return data_string;                                // Возврат строки.
    }

    // МЕТОД ЗАПИСИ ДАННЫХ В ФАЙЛ И ОБРАБОТКИ ИСКЛЮЧЕНИЙ
    public static void create_file(StringBuilder data_string) {
        try (FileWriter our_writer = new FileWriter("Task_3")) {
            our_writer.write(String.valueOf(data_string));
        } catch (Exception error) {
            System.out.println("Ошибка!");
        } finally {
            System.out.println("\nКонец работы с файлом.\n");
        }
    }

    // МЕТОД СЧИТЫВАНИЯ ДАННЫХ ИЗ ФАЙЛА
    public static void read_file() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("Task_3"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());         // Считаем данные из файла и запишем их в строку sb.
                line = br.readLine();
            }
            String jsonString = sb.toString();             // Уберем лишние знаки из строки.
            jsonString = jsonString.replaceAll("\\{", "").replaceAll("}", "");
            jsonString = jsonString.replaceAll("\"", "").replace('[', ' ').replace(']', ' ');

            String[] parts = jsonString.split(",");  // Разделим строку на логически блоки (студент), отделенные ",".
            for (String part : parts) {
                String[] params = part.split(":");   // Сформируем сообщение нужного формата.
                switch (params[0].trim()) {
                    case "фамилия" -> sb = new StringBuilder("Студент ").append(params[1]);
                    case "оценка" -> sb.append(" получил ").append(params[1]);
                    case "предмет" -> {
                        sb.append(" по предмету ").append(params[1]);
                        System.out.println(sb);           // Выведем на печать сообщение.
                    }
                }
            }
        }
    }
}
