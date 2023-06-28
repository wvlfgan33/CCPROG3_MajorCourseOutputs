package model;

public enum Denomination {
    ONE_THOUSAND(1000.0),
    FIVE_HUNDRED(500.0),
    TWO_HUNDRED(200.0),
    ONE_HUNDRED(100.0),
    FIFTY(50.0),
    TWENTY(20.0),
    TEN(10.0),
    FIVE(5.0),
    ONE(1.0);

    private double value;
    private Denomination(Double value){
        this.value = value;
    }

    public double getValue(){ return value; }
		
		
	public static Denomination of(double rawDouble) {
		Denomination[] allPossibleDenominations = Denomination.values();

		for (var possibleDenomination : allPossibleDenominations) {
			if (possibleDenomination.value == rawDouble) {
				return possibleDenomination;
			}
	
		}

		throw new IllegalArgumentException("Invalid denomination");
	}
}
