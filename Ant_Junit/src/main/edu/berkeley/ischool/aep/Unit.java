package edu.berkeley.ischool.aep;

/**
 * Understands how to convert between types of measurements
 */
public class Unit {

    public static final Unit INCHES = new Unit(1, 0, UnitType.LENGTH, "Inches");
    public static final Unit FEET = new Unit(12, 0, UnitType.LENGTH, "Feet");
    public static final Unit YARDS = new Unit(12 * 3, 0, UnitType.LENGTH, "Yards");
    public static final Unit MILES = new Unit(1760 * 36, 0, UnitType.LENGTH, "Miles");
    public static final Unit TSP = new Unit(1, 0, UnitType.VOLUME, "Tsp");
    public static final Unit TBSP = new Unit(3, 0, UnitType.VOLUME, "Tbsp");
    public static final Unit CELSIUS = new Unit(1, 0, UnitType.TEMPERATURE, "Celsius");
    public static final Unit FAHRENHEIT = new Unit(5.0 / 9.0, 32, UnitType.TEMPERATURE, "Fahrenheit");

    private enum UnitType { LENGTH, VOLUME, TEMPERATURE; }

    private final int offset;
    private final UnitType type;
    private final String name;
    private final double conversionFactor;

    public Unit(double conversionFactor, int offset, UnitType type, String name) {
        this.conversionFactor = conversionFactor;
        this.offset = offset;
        this.type = type;
        this.name = name;
    }

    public double convertTo(double size, Unit toUnit) {
        if (type != toUnit.type) {
            throw new RuntimeException("You can't compare " + type + " to " + toUnit.type);
        }
        return ((size - offset) * conversionFactor) / toUnit.conversionFactor + toUnit.offset;
    }

    @Override
    public String toString() {
        return name;
    }
}
