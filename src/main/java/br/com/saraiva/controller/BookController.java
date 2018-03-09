package br.com.saraiva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.saraiva.model.Book;
import br.com.saraiva.repository.spec.BookSpecification;
import br.com.saraiva.service.BookService;

/**
 * Book controller.
 * 
 * @author adriano.ribeiro
 *
 */
@RestController
public class BookController {

	@Autowired
	private BookService service;
	
	@GetMapping
	public Page<Book> findAll(Book book, Pageable pageable){
		
		final BookSpecification spec = new BookSpecification(book);
		
		return service.findAll(spec, pageable);
	}
	
	@GetMapping(value="/{sku}")
	public Book findOne(@PathVariable String sku){
		
		return service.findOne(sku);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping()
	public void create(@RequestParam String sku){
		
		service.save(sku);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/{sku}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String sku){
		
		service.delete(sku);
	}
	
}
