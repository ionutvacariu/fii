package eu.unicredit.fii.practic.fii.miscellaneous;

public class UserNotFoundException extends RuntimeException {

        public UserNotFoundException(Long id) {
            super("Could not find employee " + id);
        }
    }
