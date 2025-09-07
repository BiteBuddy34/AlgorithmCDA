import java.util.Scanner;

public class AlgorithmCDA {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {// Ввод координат начальной и конечной точек
            System.out.print("Введите координаты точки A (x1 y1): ");
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();

            System.out.print("Введите координаты точки B (x2 y2): ");
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();

            // Определение количества шагов (d)
            int d = Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));

            // Проверка на нулевую длину отрезка
            if (d == 0) {
                System.out.printf("Линия состоит из одной точки: (%d, %d)\n", x1, y1);
                scanner.close();
                return;
            }

            // Вычисление приращений по осям
            double deltaX = (x2 - x1) / (double) d;
            double deltaY = (y2 - y1) / (double) d;

            // Начальные координаты с учётом округления
            double x = x1 + 0.5 * sign(deltaX);
            double y = y1 + 0.5 * sign(deltaY);

            System.out.println("\nКоординаты точек отрезка:");
            System.out.printf("%-5s %-10s %-10s\n", "i", "x", "y");

            // Основной цикл построения линии
            for (int i = 1; i <= d; i++) {
                System.out.printf("%-5d %-10d %-10d\n", i, Math.round(x), Math.round(y));
                x += deltaX;
                y += deltaY;
            }
        } catch (Exception inputError) {
            System.out.println("Ошибка ввода: пожалуйста, введите целые числа.");
        }
    }

    // Функция, возвращающая -1, 0, 1 для отрицательного, нулевого, и положительного аргумента соответственно
    public static double sign(double value) {
        if (value > 0) return 1.0;
        if (value < 0) return -1.0;
        return 0.0;
    }
}
