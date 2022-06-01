public class StepTracker {
    int stepsGoal = 10000;

    Converter converter = new Converter();

    MonthData[] monthToData;


    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }

    }

    class MonthData {

        int[] days;

        public MonthData() {
            days = new int[30];
        }
    }

    void saveSteps(int month, int day, int steps) {
        if (steps >= 0) {
            monthToData[month].days[day - 1] = steps;
        }
    }

    void printMonthStat(int month) {
        if (month >= 0) {
            for (int i = 0; i < monthToData[month].days.length; i++) {
                if (i < monthToData[month].days.length - 1){
                    System.out.print((i + 1) + " день: " + monthToData[month].days[i] + " шагов, ");
                } else System.out.println((i + 1) + " день: " + monthToData[month].days[i] + " шагов.");
            }

            int stepsSumm = 0;
            for (int i = 0; i < monthToData[month].days.length; i++) {
                stepsSumm += monthToData[month].days[i];
            }
            System.out.println("\nОбщее количество шагов за указанный месяц: " + stepsSumm);

            int maxSteps = 0;
            for (int i = 0; i < monthToData[month].days.length; i++) {
                if (monthToData[month].days[i] > maxSteps) {
                    maxSteps = monthToData[month].days[i];
                }
            }
            System.out.println("Максимальное количество шагов: " + maxSteps);

            int avgSteps = 0;
            for (int i = 0; i < monthToData[month].days.length; i++) {
                avgSteps = monthToData[month].days[i] / 30;
            }
            System.out.println("Среднее количество шагов: " + avgSteps);

            double distanceCovered = converter.stepsConvert(stepsSumm);
            System.out.println("Пройденная дистанция за месяц в км: " + distanceCovered);

            double burnedCalories = converter.caloriesConvert(stepsSumm);
            System.out.println("Количество сожженных килокалорий: " + burnedCalories);

            int bestStreak = 0;
            for (int i = 0; i < monthToData[month].days.length; i++) {
                if (monthToData[month].days[i] >= stepsGoal) {
                    bestStreak++;
                }
            }
            System.out.println("Лучшая серия - " + bestStreak);
        }
    }

    int changeStepGoal(int newGoal) {
        if (newGoal >= 0) {
            stepsGoal = newGoal;
        }
        return stepsGoal;
    }
}




