import java.io.FileWriter;
import java.util.Arrays;
/*
Задание № 2 . Реализуйте алгоритм сортировки пузырьком числового массива,
результат после каждой итерации запишите в лог-файл.
 */
public class Sem_2_Hmw_Task2 {
    // ВЫЗОВ ФУНКЦИЙ
    public static void main(String[] args) {
        StringBuilder s = create_str();                    // Вызов функции формирования строки.
        create_file(s);                                    // Вызов функции создания лог-файла и обработки исключений.
    }

    // ФУНКЦИЯ ФОРМИРОВАНИЯ СТРОКИ
    public static StringBuilder create_str() {
        StringBuilder s = new StringBuilder();                               // Создать строку.
        int[] new_array = new int[]{1, 9, 2, 8, 3, 7, 4, 6, 5};
        System.out.print("Исходный числовой массив: ");
        System.out.printf(Arrays.toString(new_array));                       // Добавить  исходный массив в строку s.
        s.append("Исходный массив: \n").append(Arrays.toString(new_array)).append("\n");
        s.append("\nСортировка пузырьком: \n");

        for (int i = 0; i < new_array.length; i++) {                         // Провести сортировку пузырьком.
            for (int j = 0; j < new_array.length - 1; j++) {
                if (new_array[j] > new_array[j + 1]) {
                    int temp = new_array[j];
                    new_array[j] = new_array[j + 1];                         // Добавить каждую итерацию в строку s.
                    new_array[j + 1] = temp;
                    s.append("\ni = ").append(i).append(", j = ").append(j).append(":  ");
                    s.append(Arrays.toString(new_array)).append("\n");
                }
            }
        }
        System.out.print("\nОтсортированный массив:   ");
        System.out.printf(Arrays.toString(new_array));
        return s;                                                            // Возврат строки.
    }

    // ФУНКЦИЯ СОЗДАНИЯ ФАЙЛА И ОБРАБОТКИ ИСКЛЮЧЕНИЙ
    public static void create_file(StringBuilder s) {
        try (FileWriter our_writer = new FileWriter("Task_2")) {
            our_writer.write(String.valueOf(s));
        } catch (Exception error) {
            System.out.println("Ошибка!");
        } finally {
            System.out.println("\nКонец работы с файлом.");
        }
    }
}

