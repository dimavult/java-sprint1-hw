import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            switch(command) {
                case (1):
                    stepTracker.saveSteps();
                    break;
                case (2):
                    stepTracker.printMonthStat();
                    break;
                case (3):
                    stepTracker.changeStepGoal();
                    break;
                case (0):
                    return;
                default:
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

