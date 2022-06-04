import java.util.Scanner;

public class StepTracker {
    private int stepsGoal = 10000;
    private int stepsSum;


    private static final String chooseMonth = "0 - Январь," +
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

    Converter converter = new Converter();

    Scanner scanner = new Scanner(System.in);

    private MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }

    }

    public static class MonthData {

        private int[] days;

        public MonthData() {
            days = new int[30];
        }
    }

    public void saveSteps() {
            System.out.println("Выберите месяц: " + chooseMonth);
            int month = scanner.nextInt();
            while (month < 0 || month > 11) {
                System.out.println("Неправильно указан месяц\nВведите значение от 0 до 11.");
                month = scanner.nextInt();
            }

            System.out.println("Выберите день:");
            int day = scanner.nextInt();
            while (day < 1 || day > 30){
                System.out.println("Неправильно указан день\nВведите значение от 1 до 30.");
                day = scanner.nextInt();
            }

            System.out.println("Укажите количество шагов:");
            int steps = scanner.nextInt();
            while (steps < 0) {
                System.out.println("Количество шагов не может быть отрицательным. Введите положительное число или 0.");
                steps = scanner.nextInt();
            }
            monthToData[month].days[day - 1] = steps;
        }



    public void printStepsPerDay(int month) {
        for (int i = 0; i < monthToData[month].days.length; i++) {
            if (i < monthToData[month].days.length - 1) {
                System.out.print((i + 1) + " день: " + monthToData[month].days[i] + " шагов, ");
            } else System.out.println((i + 1) + " день: " + monthToData[month].days[i] + " шагов.");
        }
    }

    public void findMonthStepsSum(int month) {
        stepsSum = 0;
        for (int i = 0; i < monthToData[month].days.length; i++) {
            stepsSum += monthToData[month].days[i];
        }
        System.out.println("Общее количество шагов за указанный месяц: " + stepsSum);
    }


    public void findMaxSteps(int month) {
        int maxSteps = 0;
        for (int i = 0; i < monthToData[month].days.length; i++) {
            if (monthToData[month].days[i] > maxSteps) {
                maxSteps = monthToData[month].days[i];
            }
        }
        System.out.println("Максимальное количество шагов: " + maxSteps);
    }

    public void findAverageSteps(int month) {
        int avgSteps = 0;
        for (int i = 0; i < monthToData[month].days.length; i++) {
            avgSteps += monthToData[month].days[i] / 30;
        }
        System.out.println("Среднее количество шагов: " + avgSteps);
    }

    public void findBestStreak(int month) { //Вернуться, доделать
        int bestStreak = 0;
        int currentStreak = 0;
        for (int i = 0; i < monthToData[month].days.length; i++) {
            if (monthToData[month].days[i] >= stepsGoal) {
                currentStreak++;
            } else if (monthToData[month].days[i] < stepsGoal && currentStreak > bestStreak) {
                bestStreak = currentStreak;
                currentStreak = 0;
            }
        }
        System.out.println("Лучшая серия (в днях) - " + bestStreak);
    }

    public void printMonthStat() {
        System.out.println("За какой месяц хотите посмотреть Ваши достижения? " + chooseMonth);
        int month = scanner.nextInt();
        while (month < 0 || month > 11) {
            System.out.println("Неправильно указан месяц\nnВведите значение от 0 до 11.");
            month = scanner.nextInt();
        }

        printStepsPerDay(month); // Daily steps statistics
        findMonthStepsSum(month); // Total steps per month
        findMaxSteps(month); // Max steps per day
        findAverageSteps(month); // Average number of steps per month
        double distanceCovered = converter.stepsConvert(stepsSum);
        System.out.println("Пройденная дистанция за месяц в км: " + distanceCovered);

        double burnedCalories = converter.caloriesConvert(stepsSum);
        System.out.println("Количество сожженных килокалорий: " + burnedCalories);

        findBestStreak(month);
    }

    public void changeStepGoal() {
        System.out.println("Введите Вашу новую цель: ");
        int newGoal = scanner.nextInt();
        if (newGoal >= 0) {
            stepsGoal = newGoal;
        } else System.out.println("Количество шагов до цели не может быть отрицательным.");
    }
}








