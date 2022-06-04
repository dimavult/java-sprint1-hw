public class Converter {

    private static final int C_P_S= 50; // Calories per step

    private static final double S_K = 0.00075; // 1 step == 75 centimetre => 75 centimetres == 0.00075 kilometres

    public double caloriesConvert(int steps){
        return steps * C_P_S / 1000;
    }

    public double stepsConvert(int steps){
        return steps * S_K;
    }
}

