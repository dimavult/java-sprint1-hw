public class Converter {
    double distance;
    double calories;

    public double caloriesConvert(int steps){
        return calories = steps * 50 / 1000; // 1 step = 50 calories
    }

    public double stepsConvert(int steps){
        return distance = steps * 0.00075; // 75 cm = 0.00075 km
    }
}
