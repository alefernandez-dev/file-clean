package alexdev.fileclean.frameworkPackage;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.Serializable;

@RestControllerAdvice
public class AppExceptionHandler {

   @ExceptionHandler(Exception.class)
   ResponseEntity<ErrorMessage> handlerException(Exception e) {
        return ResponseEntity.internalServerError().body(new ErrorMessage(e.getMessage()));
    }

    record ErrorMessage(String message) implements Serializable {}

}
