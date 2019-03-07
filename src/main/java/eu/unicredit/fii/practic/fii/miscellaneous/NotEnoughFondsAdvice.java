package eu.unicredit.fii.practic.fii.miscellaneous;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotEnoughFondsAdvice {
    @ResponseBody
    @ExceptionHandler(NotEnoughFondsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String notEnoughFondsHandler(NotEnoughFondsException ex) {
        return ex.getMessage();
    }
}
