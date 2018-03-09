package br.com.saraiva.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Sku already exists exception.
 * @author Adriano
 *
 */
@ResponseStatus(value=HttpStatus.CONFLICT, reason="O SKU já existe.")
public class SkuAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = -6967720480492433626L;

}
