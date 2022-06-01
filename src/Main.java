import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        String chooseMonth = "0 - Январь," +
                             " 1 - Февраль," +
                             " 2 - Март," +
                             " 3 - Апрель," +
                             " 4 - Май," +
                             " 5 - Июнь," +
                             " 6 - Июль," +
                             " 7 - Август," +
                             " 8 - Сентябрь," +
                             " 9 - Октябрь," +
                             " 10 - Ноябрь," +
                             " 11 - Декабрь.";

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                System.out.println("Выберите месяц: " + chooseMonth);
                int month = scanner.nextInt();
                System.out.println("Выберите день:");
                int day = scanner.nextInt();
                System.out.println("Укажите количество шагов:");
                int steps = scanner.nextInt();
                stepTracker.saveSteps(month, day, steps);
            } else if (command == 2) {
                System.out.println("За какой месяц хотите посмотреть Ваши достижения? " + chooseMonth);
                int month = scanner.nextInt();
                stepTracker.printMonthStat(month);
            } else if (command == 3) {
                System.out.println("Введите Вашу новую цель: ");
                int newGoal = scanner.nextInt();
                stepTracker.changeStepGoal(newGoal);
            } else if (command == 0) {
                    break;
            } else {
                System.out.println("Извините, такой команды еще нет. Попробуйте выбрать команду из списка.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("1 - Ввести количество шагов за определённый день.");
        System.out.println("2 - Вывести статистику за определённый месяц.");
        System.out.println("3 - Изменить цель.");
        System.out.println("0 - Выйти из приложения.");
    }
}

