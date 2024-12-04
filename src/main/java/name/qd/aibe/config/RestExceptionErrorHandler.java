package name.qd.aibe.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionErrorHandler {

    @ExceptionHandler(value = AIBEException.class)
    protected ResponseEntity<String> handleAIBEException(AIBEException aibeException) throws JsonProcessingException {
        return ResponseEntity.badRequest().body(aibeException.getMessage());
    }

    @ExceptionHandler(value = JsonProcessingException.class)
    protected ResponseEntity<String> handleJsonProcessingException(JsonProcessingException jsonProcessingException) {
        return ResponseEntity.badRequest().body(jsonProcessingException.getMessage());
    }
}
