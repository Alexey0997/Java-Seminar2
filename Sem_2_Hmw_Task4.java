import java.io.FileWriter;
import java.util.Scanner;

/*
Реализовать простой калькулятор. Добавить логирование.
 */
public class Sem_2_Hmw_Task4 {
    // ВЫЗОВ ФУНКЦИЙ
    public static void main(String[] args) {
        StringBuilder s = calculator();                    // Вызов калькулятора.
        log_file(s);                                       // Вызов функции создания лог-файла и обработки исключений.
    }

    // ФУНКЦИЯ КАЛЬКУЛЯТОРА

    public static StringBuilder calculator() {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите первое число: ");        // Запрашиваем первое число.
        double a = iScanner.nextDouble();

        System.out.print("Введите знак: +, -, / или *: "); // Запрашиваем знак операции.
        String sign = iScanner.next();

        System.out.print("Введите второе число: ");        // Запрашиваем второе число.
        double b = iScanner.nextDouble();
        double result;
        StringBuilder log_string = new StringBuilder();

        switch (sign) {                                    // Используем оператор выбора для рассчета результата.
            case "+" -> {
                result = a + b;                            // Сложение.
                System.out.print("Результат вычисления: ");
                System.out.println(result);                // Вычисление и результат запишем в строку log_string.
                log_string.append(a).append(" ").append(sign).append(" ").append(b).append(" = ").append(result);
                return log_string;
            }
            case "-" -> {
                result = a - b;                            // Вычитание.
                System.out.print("Результат вычисления: ");
                System.out.println(result);                // Вычисление и результат запишем в строку log_string.
                log_string.append(a).append(" ").append(sign).append(" ").append(b).append(" = ").append(result);
                return log_string;
            }
            case "/" -> {
                result = a / b;                             // Деление.
                System.out.print("Результат вычисления: ");
                System.out.println(result);                 // Вычисление и результат запишем в строку log_string.
                log_string.append(a).append(" ").append(sign).append(" ").append(b).append(" = ").append(result);
                return log_string;
            }
            case "*" -> {
                result = a * b;                             // Умножение.
                System.out.print("Результат вычисления: ");
                System.out.println(result);                 // Вычисление и результат запишем в строку log_string.
                log_string.append(a).append(" ").append(sign).append(" ").append(b).append(" = ").append(result);
                return log_string;
            }
            default -> {
                log_string.append("default");
                return log_string;
            }
        }
    }

    // ФУНКЦИЯ ЛОГИРОВАНИЯ
    public static void log_file(StringBuilder log_string){   // Математические действия запишем в файл Task_4.
        try (FileWriter our_writer = new FileWriter("Task_4")) {
            our_writer.write(String.valueOf(log_string));
        } catch (Exception error) {
            System.out.println("Ошибка!");
        } finally {
            System.out.println("\nКонец работы с файлом.");
        }
    }
}
