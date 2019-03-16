package com.uaic.bankTrx.misc;

public class AmountOverTenThousand extends Exception {
	public AmountOverTenThousand(Double amount) {
		super("Your transaction is :" + amount + " and cannot be made. Your amount should be declared to FISC!");
	}

}
