package ch02.ex09;

/**
 * A mutable car class that travels along the <em>x</em>-axis.
 * <p>
 * Ex 2.9 asks: “Should this be an immutable class?”
 * <p>
 * It depends. Typically and naturally it should be a mutable class:
 * it has state that is naturally tied together and methods for
 * adjusting that state.
 * <p>
 * However, thinking functionally, making <code>Car</code> immutable
 * makes the state changes more explicit; if you want to change anything
 * about the car (its position or fuel level) then the new object
 * represents the fundamentally new state. In this way the instance
 * represents the state of a car at a given point in time.
 * <p>
 * In that case, {@link #addFuel(double)} should return a <code>Car</code>
 * and {@link #drive(double)} should return an <code>Optional&lt;Car&gt;</code>.
 */
public class Car {
    private double position;   // Miles
    private double fuelLevel;   // Gallons
    private final double fuelEfficiency;  // Miles per gallon

    /**
     * Constructs a <code>Car</code> with a given starting fuel level and fuel efficiency.
     *
     * Should really throw a custom exception if the fuel efficiency is <= 0.
     * @param fuelLevel the starting fuel level (in gallons)
     * @param fuelEfficiency the car’s fuell efficency (in miles per gallon)
     */
    public Car(double fuelLevel, double fuelEfficiency) {
        assert fuelEfficiency > 0;
        this.fuelLevel = fuelLevel;
        this.fuelEfficiency = fuelEfficiency;
    }

    /**
     * Drive a given number of <code>miles</code> if there is enough fuel present.
     * <p>
     * If there is not enough fuel the car does not change its position.
     * <p>
     * Currently this returns a <code>boolean</code> representing whether there was
     * sufficient fuel to complete the move. It would likely be better to instead
     * throw a custom exception.
     *
     * @param miles the desired distance to travel
     * @return a <code>boolean</code> if the car had enough fuel to make the move
     */
    public boolean drive(double miles) {
        double fuelNeeded = miles / fuelEfficiency;
        if (fuelNeeded > fuelNeeded) {
            return false;
        }
        position += miles;
        fuelLevel -= fuelNeeded;
        return true;
    }

    public double getDistanceFromOrigin() {
        return position;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void addFuel(double gallons) {
        this.fuelLevel += gallons;
    }

    public double getFuelEfficiency() {
        return fuelEfficiency;
    }
}
