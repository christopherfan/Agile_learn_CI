package edu.berkeley.ischool.aep;

import org.junit.Test;
import static edu.berkeley.ischool.aep.Unit.*;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class QuantityTest {

    @Test
    public void threeFeetShouldEqualOneYard() {
		System.out.println(">!!!Verifying Quantity Test is running Test 1");
        assertEquals(new ArithmeticQuantity(1, YARDS), new ArithmeticQuantity(3, FEET));
    }

    @Test
    public void oneThousandSomethingYardsShouldEqualOneMile() {
        assertEquals(new ArithmeticQuantity(1760, YARDS), new ArithmeticQuantity(1, MILES));
    }

    @Test
    public void oneTbspShouldEqualThreeTsp() {
        assertEquals(new ArithmeticQuantity(1, TBSP), new ArithmeticQuantity(3, TSP));
    }

    @Test
    public void twoInchesPlusTwoInchesShouldEqualFourInches() {
        assertEquals(new ArithmeticQuantity(4, INCHES),
                new ArithmeticQuantity(2, INCHES).add(new ArithmeticQuantity(2, INCHES)));
    }

    @Test
    public void twoHundredTwelveFahrenheitShouldEqual100C() {
        assertEquals(new ScaledQuantity(212, FAHRENHEIT), new ScaledQuantity(100, CELSIUS));
    }

    @Test
    public void OneHundredCelsiusShouldBeBetterThanZeroCelsius() {
        assertTrue(new ScaledQuantity(100, CELSIUS).betterThan(new ScaledQuantity(0, CELSIUS)));
    }

    @Test
    public void zeroCelsiusShouldEqualThirtyTwoFahrenheit() {
        assertEquals(new ScaledQuantity(0, CELSIUS), new ScaledQuantity(32, FAHRENHEIT));
    }

    @Test
    public void tenCelsiusShouldBeBetterThanThirtyTwoFahrenheit() {
        assertTrue(new ScaledQuantity(10, CELSIUS).betterThan(new ScaledQuantity(32, FAHRENHEIT)));
    }

    @Test(expected = Exception.class)
    public void tenCelsiusShouldNotBeComparableToTenInches() {
        assertTrue(new ScaledQuantity(10, INCHES).betterThan(new ScaledQuantity(10, CELSIUS)));
    }

    @Test
    public void shouldReturnBestQuantityFromArray() {
        assertEquals(new ScaledQuantity(10, INCHES), new Bester(
                new ScaledQuantity(2, INCHES),
                new ScaledQuantity(10, INCHES),
                new ScaledQuantity(5, INCHES)).best());
    }

    @Test(expected = NullPointerException.class)
    public void shouldPunishIdiocy() {
        new Bester(null);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldReturnBestQuantityFromArraySizeZero() {
        assertEquals(new ScaledQuantity(10, INCHES), new Bester().best());
    }

}
