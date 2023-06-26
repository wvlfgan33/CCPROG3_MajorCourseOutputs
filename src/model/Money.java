package model;
import java.util.HashMap;
import java.util.Map;

class insufficientDenominationsException extends Exception {}

public class Money {

	private Map<Denomination, Integer> money = new HashMap<>();
		
	public Money() {
		this.money.put(Denomination.ONE_THOUSAND, 0);
		this.money.put(Denomination.FIVE_HUNDRED, 0);
		this.money.put(Denomination.TWO_HUNDRED, 0);
		this.money.put(Denomination.ONE_HUNDRED, 0);
		this.money.put(Denomination.FIFTY, 0);
		this.money.put(Denomination.TWENTY, 0);
		this.money.put(Denomination.TEN, 0);
		this.money.put(Denomination.FIVE, 0);
		this.money.put(Denomination.ONE, 0);
	}
	
	public Money(int ones, int fives, int tens, int twenties, int fifties, int hundreds, int twohundreds, int fivehundreds, int thousands) {
		this.money.put(Denomination.ONE_THOUSAND, thousands);
		this.money.put(Denomination.FIVE_HUNDRED, fivehundreds);
		this.money.put(Denomination.TWO_HUNDRED, twohundreds);
		this.money.put(Denomination.ONE_HUNDRED, hundreds);
		this.money.put(Denomination.FIFTY, fifties);
		this.money.put(Denomination.TWENTY, twenties);
		this.money.put(Denomination.TEN, tens);
		this.money.put(Denomination.FIVE, fives);
		this.money.put(Denomination.ONE, ones);
	}

	public Map<Denomination, Integer> getMoney() {
		return this.money;
	}

	public Money convertFromNumber(double number) throws insufficientDenominationsException {
		int onesCount = 0;
		int fivesCount = 0;
		int tensCount = 0;
		int twentiesCount = 0;
		int fiftiesCount = 0;
		int hundredsCount = 0;
		int twoHundredsCount = 0;
		int fiveHundredsCount = 0;
		int thousandsCount = 0;
		
		while (number >= 0) {
			if (number >= 1000 && this.money.get(Denomination.ONE_THOUSAND) > 0) {
				thousandsCount++;
				this.money.put(Denomination.ONE_THOUSAND, this.money.get(Denomination.ONE_THOUSAND) - 1);
				number -= 1000;
				continue;
			} else if (number >= 500 && this.money.get(Denomination.FIVE_HUNDRED) > 0) {
				fiveHundredsCount++;
				this.money.put(Denomination.FIVE_HUNDRED, this.money.get(Denomination.FIVE_HUNDRED) - 1);
				number -= 500;
				continue;
			} else if (number >= 200 && this.money.get(Denomination.TWO_HUNDRED) > 0) {
				twoHundredsCount++;
				this.money.put(Denomination.TWO_HUNDRED, this.money.get(Denomination.TWO_HUNDRED) - 1);
				number -= 200;
				continue;
			} else if (number >= 100 && this.money.get(Denomination.ONE_HUNDRED) > 0) {
				hundredsCount++;
				this.money.put(Denomination.ONE_HUNDRED, this.money.get(Denomination.ONE_HUNDRED) - 1);
				number -= 100;
				continue;
			} else if (number >= 50 && this.money.get(Denomination.FIFTY) > 0) {
				fiftiesCount++;
				this.money.put(Denomination.FIFTY, this.money.get(Denomination.FIFTY) - 1);
				number -= 50;
				continue;
			} else if (number >= 20 && this.money.get(Denomination.TWENTY) > 0) {
				twentiesCount++;
				this.money.put(Denomination.TWENTY, this.money.get(Denomination.TWENTY) - 1);
				number -= 20;
				continue;
			} else if (number >= 10 && this.money.get(Denomination.TEN) > 0) {
				tensCount++;
				this.money.put(Denomination.TEN, this.money.get(Denomination.TEN) - 1);
				number -= 10;
				continue;
			} else if (number >= 5 && this.money.get(Denomination.FIVE) > 0) {
				fivesCount++;
				this.money.put(Denomination.FIVE, this.money.get(Denomination.FIVE) - 1);
				number -= 5;
				continue;
			} else if (number >= 1 && this.money.get(Denomination.ONE) > 0) {
				onesCount++;
				this.money.put(Denomination.ONE, this.money.get(Denomination.ONE) - 1);
				number--;
				continue;
			} else {
				break;
			}
		}
		
		if (number != 0) {
			throw new insufficientDenominationsException();
		}
		
		return new Money(onesCount, fivesCount, tensCount, twentiesCount, fiftiesCount, hundredsCount, twoHundredsCount, fiveHundredsCount, thousandsCount);
		
	}

	public double toDouble() {
		double total = 0;
		for (var d : this.money.entrySet()) {
			total += d.getKey().getValue() * d.getValue();
		}
		return total;
		
	}


	public Money subtract(Money payment, Money cost) throws insufficientDenominationsException {
		double a = payment.toDouble();
		double b = cost.toDouble();
		double difference = a - b;
		
		this.money.put(Denomination.ONE_THOUSAND, this.money.get(Denomination.ONE_THOUSAND) + payment.money.get(Denomination.ONE_THOUSAND));
		this.money.put(Denomination.FIVE_HUNDRED, this.money.get(Denomination.FIVE_HUNDRED) + payment.money.get(Denomination.FIVE_HUNDRED));
		this.money.put(Denomination.TWO_HUNDRED, this.money.get(Denomination.TWO_HUNDRED) + payment.money.get(Denomination.TWO_HUNDRED));
		this.money.put(Denomination.ONE_HUNDRED, this.money.get(Denomination.ONE_HUNDRED) + payment.money.get(Denomination.ONE_HUNDRED));
		this.money.put(Denomination.FIFTY, this.money.get(Denomination.FIFTY) + payment.money.get(Denomination.FIFTY));
		this.money.put(Denomination.TWENTY, this.money.get(Denomination.TWENTY) + payment.money.get(Denomination.TWENTY));
		this.money.put(Denomination.TEN, this.money.get(Denomination.TEN) + payment.money.get(Denomination.TEN));
		this.money.put(Denomination.FIVE, this.money.get(Denomination.FIVE) + payment.money.get(Denomination.FIVE));
		this.money.put(Denomination.ONE, this.money.get(Denomination.ONE) + payment.money.get(Denomination.ONE));
		
		return this.convertFromNumber(difference);
	}


}