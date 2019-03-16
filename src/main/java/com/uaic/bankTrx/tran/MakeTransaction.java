package com.uaic.bankTrx.tran;

import com.uaic.bankTrx.misc.AmountOverTenThousand;
import com.uaic.bankTrx.model.Transaction;
import com.uaic.bankTrx.model.User;
import com.uaic.bankTrx.repository.TransactionRepository;
import com.uaic.bankTrx.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(rollbackFor = Exception.class)
public class MakeTransaction implements MakeTran {

	public static final int TEN_THOUSAND = 10000;
	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	UserRepository userRepository;

	private void substractAmount(User u, Double amount) throws Exception {
		u.setAmount(u.getAmount() - amount);
		//userRepository.save(u);

	}

	private void addAmount(User u, Double amount) {
		u.setAmount(u.getAmount() + amount);
		//userRepository.save(u);
	}

	@Override
	public Transaction makeTransaction(User from, User to, Transaction transaction) throws Exception {
		final Double amount = transaction.getAmount();
		substractAmount(from, amount);
		addAmount(to, amount);
		transaction.setFromUser(from)
		;
		transaction.setToUser(to);
		return persistTransactionsLessThanFiveHoundred(transaction);
	}

	private Transaction persistTransactionsLessThanFiveHoundred(Transaction t) throws Exception {
		if (t.getAmount() > TEN_THOUSAND) {
			throw new AmountOverTenThousand(t.getAmount());
		}

		return transactionRepository.save(t);
	}
}
