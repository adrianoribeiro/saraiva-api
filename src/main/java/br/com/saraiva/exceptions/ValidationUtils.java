package br.com.saraiva.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 * Classe de validação.
 * 
 * @author Adriano
 *
 */
public class ValidationUtils {

	private ValidationUtils(){}
	
	public static List<ObjectError> getBindingResultErros(BindingResult result) {

		final List<ObjectError> listErrors = new ArrayList<>();
		result.getAllErrors().stream().forEach(
				objectError -> listErrors.add(objectError));
		
		return listErrors;
	}
}
