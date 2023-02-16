import java.io.FileWriter;
/*
1 . Дана строка sql-запроса "select * from students where ".
Сформируйте часть WHERE этого запроса, используя StringBuilder.
Данные для фильтрации приведены ниже в виде json строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
*/
public class Sem_2_Hmw_Task1 {
    // ВЫЗОВ ФУНКЦИЙ
    public static void main(String[] args) {
        StringBuilder sql_query = create_SQL();       // Вызов метода формирования строки.
        create_file(sql_query);                       // Вызов метода создания лог-файла и обработки исключений.
    }

    // ФУНКЦИЯ ФОРМИРОВАНИЯ SQL-ЗАПРОСА
    public static StringBuilder create_SQL() {
        String question = "select * from students where";
        StringBuilder sql_query = new StringBuilder();
        sql_query.append(question);                                    // Инициализация json-строки.
        String jsonString = "{\"name\":\"Ivanov\",\"country\":\"Russia\",\"city\":\"Moscow\",\"age\":\"null\"}";
        jsonString = jsonString.replace("{", "").replace("}", "");
        jsonString = jsonString.replace("\"", "");    // Замена символов строки.

        String[] new_string = jsonString.split(",");             // Отделяем логические пары, перечисленные через ",".
        for (String elem : new_string) {                               // Цикл работы с элементами строки после их разбивки по ":".
            String[] pair = elem.split(":");
            if (pair.length > 1) {
                if (!pair[1].equalsIgnoreCase("null")) {    // Исключение вывода элемента, содержащего "null".
                    sql_query.append("\n").append(pair[0]).append(" = \"");
                    sql_query.append(pair[1]).append("\" and");        // Формирование запроса из двух элементов пары.
                }
            }
        }                                                              // Удаление лишнего "and" в конце запроса.
        if (sql_query.substring(sql_query.length() - 3, sql_query.length()).equals("and")) {
            sql_query.delete(sql_query.length() - 3, sql_query.length());
        }
        System.out.printf("SQL-question: %s", sql_query);
        return sql_query;                                              // Возврат строки.
    }

    // ФУНКЦИЯ СОЗДАНИЯ ФАЙЛА И ОБРАБОТКИ ИСКЛЮЧЕНИЙ
    public static void create_file(StringBuilder sql_query) {
        try (FileWriter our_writer = new FileWriter("Task_1")) {
            our_writer.write(String.valueOf(sql_query));
        } catch (Exception error) {
            System.out.println("Ошибка!");
        } finally {
            System.out.println("\nКонец работы с файлом.");
        }
    }
}


