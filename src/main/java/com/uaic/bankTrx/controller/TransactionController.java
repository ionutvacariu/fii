package com.uaic.bankTrx.controller;

import com.uaic.bankTrx.misc.NotEnoughFundsException;
import com.uaic.bankTrx.misc.UserNotFoundException;
import com.uaic.bankTrx.model.Transaction;
import com.uaic.bankTrx.model.User;
import com.uaic.bankTrx.repository.TransactionRepository;
import com.uaic.bankTrx.repository.UserRepository;
import com.uaic.bankTrx.tran.MakeTran;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MakeTran makeTran;

	public TransactionController(TransactionRepository transactionRepository, UserRepository userRepository) {
		this.transactionRepository = transactionRepository;

		this.userRepository = userRepository;
	}

	@GetMapping("/transactions")
	List<Transaction> all() {
		return transactionRepository.findAll();
	}

	@PostMapping("/transactions")
	Transaction newTransaction(
			@RequestBody
					Transaction newTransaction) throws Exception {
		User from = userRepository.findById(newTransaction.getFromUser().getId())
				.orElseThrow(() -> new UserNotFoundException(newTransaction.getFromUser().getId()));
		User to = userRepository.findById(newTransaction.getToUser().getId())
				.orElseThrow(() -> new UserNotFoundException(newTransaction.getToUser().getId()));

		return makeTran.makeTransaction(from, to, newTransaction);

	}
}
