package com.uaic.bankTrx.tran;

import com.uaic.bankTrx.model.Transaction;
import com.uaic.bankTrx.model.User;

public interface MakeTran {
	Transaction makeTransaction(User from, User to, Transaction amount) throws Exception;
}
