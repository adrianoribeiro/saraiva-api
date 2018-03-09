package br.com.saraiva.exceptions;

import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Manipula os erros do controller.
 * 
 * @author Adriano
 *
 */
@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> invalidInput(MethodArgumentNotValidException ex) {
        
        BindingResult result = ex.getBindingResult();
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("Erros de validação");
        response.setErrorMessage("Valores inválidos.");
        response.setErrors(result.getAllErrors());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

    }
	
    @ExceptionHandler(SkuAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> resourceAlreadyExists(ResourceNotFoundException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("SKU already exists");
        response.setErrorMessage(ex.getMessage());

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(SkuNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("SKU not found");
        response.setErrorMessage(ex.getMessage());

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
    }
}
