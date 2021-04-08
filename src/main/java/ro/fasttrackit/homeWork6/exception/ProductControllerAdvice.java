package ro.fasttrackit.homeWork6.exception;

import lombok.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductControllerAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
    ApiError handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
        return new ApiError(productNotFoundException.getMessage());
    }
}

@Value
class ApiError {
    String message;
}
