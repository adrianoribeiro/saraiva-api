package br.com.saraiva.exceptions;

import java.util.List;

import org.springframework.validation.ObjectError;

/**
 * 
 * Classe responsável por receber os erros do controller.
 * 
 * @author Adriano
 *
 */
public class ExceptionResponse {
    private String errorCode;
    private String errorMessage;
    private List<ObjectError> errors;

    public ExceptionResponse() {}

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

	public List<ObjectError> getErrors() {
		return errors;
	}

	public void setErrors(List<ObjectError> errors) {
		this.errors = errors;
	}
}
