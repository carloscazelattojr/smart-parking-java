package br.com.carlosjunior.smartparking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(NotFoundException ex,
                                                                        WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                ex.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDetails> handleBlogAPIException(BadRequestException ex,
                                                               WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                ex.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorDetails> handleUnexpectedException(Throwable ex,
                                                                  WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                ex.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//                                                                   HttpHeaders headers,
//                                                                   HttpStatus status,
//                                                                   WebRequest request) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((err) -> {
//            String fieldName = ((FieldError) err).getField();
//            String message = err.getDefaultMessage();
//            errors.put(fieldName, message);
//        });
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }


}
