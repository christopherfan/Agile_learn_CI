package edu.berkeley.ischool.aep;

public class ArithmeticQuantity extends ScaledQuantity {

    public ArithmeticQuantity(double size, Unit units) {
        super(size, units);
    }

    public ArithmeticQuantity add(ArithmeticQuantity other) {
        return new ArithmeticQuantity(size + other.convertTo(units), units);
    }
	
	public static void main(String [] args)
    {
       System.out.println("Edu.Berkeley.Ischool.aep Arithmetic Class Main Running [AEP] Package!!!!!!!!");
    }

}

