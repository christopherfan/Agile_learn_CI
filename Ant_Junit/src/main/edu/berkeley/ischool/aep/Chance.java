package edu.berkeley.ischool.aep;

/**
 * Understands the likelihood of something happening
 */
public class Chance implements Bestable <Chance> {
    private final double probability;

    public Chance(double probability) {
        this.probability = probability;
    }

    @Override
    public boolean equals(Object other) {

        if (other == this) return true;
        if (!(other instanceof Chance)) return false;
        return Math.abs(probability - ((Chance) other).probability) < 0.0001;
    }

    @Override
    public int hashCode() {
        long longBits = Double.doubleToLongBits(probability);
        return (int) (longBits ^ (longBits >>> 32));
    }

    @Override
    public String toString() {
        return "Value " + probability;
    }

    public Chance not() {
        return new Chance(1 - probability);
    }

    @Override
    public boolean betterThan(Chance other) {
       return probability > other.probability;
    }
}
