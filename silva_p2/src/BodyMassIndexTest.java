
import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {

    // Obesity
    @org.junit.jupiter.api.Test
    void bmiScore1()
    {
        // BodyMassIndex value = new BodyMassIndex(100, 600);
        assertEquals(42.0, BodyMassIndex.bmiScore(100,600));
    }

    @org.junit.jupiter.api.Test
    void bmiCategory1()
    {
        assertEquals("Obesity >= 30", BodyMassIndex.bmiCategory(42.0));
    }


    // Overweight
    @org.junit.jupiter.api.Test
    void bmiScore2()
    {
        assertEquals(28.0, BodyMassIndex.bmiScore(100,400));
    }

    @org.junit.jupiter.api.Test
    void bmiCategory2()
    {
        assertEquals("Overweight = 25–29.9", BodyMassIndex.bmiCategory(28.0));
    }


    // Normal weight
    @org.junit.jupiter.api.Test
    void bmiScore3()
    {
        assertEquals(22.0, BodyMassIndex.bmiScore(160,800));
    }

    @org.junit.jupiter.api.Test
    void bmiCategory3()
    {
        assertEquals("Normal weight = 18.5–24.9", BodyMassIndex.bmiCategory(22.0));
    }


    // Underweight
    @org.junit.jupiter.api.Test
    void bmiScore4()
    {
        assertEquals(7.00, BodyMassIndex.bmiScore(170,300));
    }

    @org.junit.jupiter.api.Test
    void bmiCategory4()
    {
        assertEquals("Underweight < 18.5", BodyMassIndex.bmiCategory(7.00));
    }
}
