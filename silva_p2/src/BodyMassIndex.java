// Julia de Macedo Soares da Silva
// COP 3330 - ju649983

public class BodyMassIndex
{
    double userScore;
    String userCategory;

    public BodyMassIndex(double height, double weight)
    {
        this.userScore = bmiScore(height, weight);
        this.userCategory = bmiCategory(bmiScore(height, weight));
    }

    // The `BodyMassIndex` class contains a public method to calculate BMI score based on a height and weight value.
    public static double bmiScore(double userHeight, double userWeight)
    {
        double bmi = Math.round(userWeight * 703.00 / userHeight / userHeight);
        System.out.printf("BMI = %.2f", bmi);
        return bmi;
    }

    // The `BodyMassIndex` class contains a public method to calculate BMI category based on a height and weight value.
    public static String bmiCategory(double bmi)
    {
        String category = "";
        if (bmi < 18.5)
            category = "Underweight < 18.5";
        else if (bmi < 25)
            category = "Normal weight = 18.5–24.9";
        else if (bmi < 30)
            category ="Overweight = 25–29.9";
        else
            category ="Obesity >= 30";

        return category;
    }

}
