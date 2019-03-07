package eu.unicredit.fii.practic.fii.controller;

import eu.unicredit.fii.practic.fii.miscellaneous.NotEnoughFondsException;
import eu.unicredit.fii.practic.fii.miscellaneous.UserNotFoundException;
import eu.unicredit.fii.practic.fii.model.Transaction;
import eu.unicredit.fii.practic.fii.model.User;
import eu.unicredit.fii.practic.fii.repository.TransactionRepository;
import eu.unicredit.fii.practic.fii.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    private final TransactionRepository transactionRepository;

    private final UserRepository userRepository;

    public TransactionController(TransactionRepository transactionRepository, UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/transactions")
    Transaction newTransaction(@RequestBody Transaction newTransaction) {
        User from = userRepository.findById(newTransaction.getFromUser())
                .orElseThrow(() -> new UserNotFoundException(newTransaction.getFromUser()));

        User to = userRepository.findById(newTransaction.getToUser())
                .orElseThrow(() -> new UserNotFoundException(newTransaction.getToUser()));
        if (from.getAmount() >= newTransaction.getAmount()) {
            from.setAmount(from.getAmount() - newTransaction.getAmount());
            to.setAmount(to.getAmount() + newTransaction.getAmount());
            userRepository.save(from);
            userRepository.save(to);
            return transactionRepository.save(newTransaction);
        } else {
            throw new NotEnoughFondsException(newTransaction.getAmount());
        }
    }

}
