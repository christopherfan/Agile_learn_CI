package edu.berkeley.ischool.aep;

/**
 * Understands unit and value for a measurement
 */
public class ScaledQuantity implements Bestable<ScaledQuantity> {
    protected final Unit units;
    protected double size;

    public ScaledQuantity(double size, Unit units) {
        this.units = units;
        this.size = size;
    }

    protected double convertTo(Unit toUnits) {
        return units.convertTo(size, toUnits);
    }

    private boolean equals(ScaledQuantity other) {
        return Math.abs(size - other.convertTo(units)) < 0.0001;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof ScaledQuantity)) return false;
        return equals((ScaledQuantity) other);
    }

    @Override
    public int hashCode() {
        return 42;
    }

    @Override
    public String toString() {
        return size + " " + units.toString();
    }

    @Override
    public boolean betterThan(ScaledQuantity other) {
        double otherSize = other.convertTo(this.units);
        return this.size > otherSize;
    }
}
