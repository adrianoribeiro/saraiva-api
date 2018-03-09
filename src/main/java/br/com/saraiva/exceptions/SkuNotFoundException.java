package br.com.saraiva.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Sku not found exception.
 * @author Adriano
 *
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="O SKU não existe.")
public class SkuNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5903848309910729373L;

}
