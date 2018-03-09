package br.com.saraiva.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import br.com.saraiva.model.stub.BookStub;

public final class ApiUtil {

	private static final String URI_API = "https://api.saraiva.com.br/sc/produto/pdp/{sku}/0/0/1/";

	public static BookStub callApi(final String sku) {
		
		Map<String, String> params = new HashMap<>();
	    params.put("sku", sku);
		
		RestTemplate restTemplate = new RestTemplate();
		BookStub bookStub = restTemplate.getForObject(URI_API, BookStub.class, params);
		return bookStub;
	}
	
}
