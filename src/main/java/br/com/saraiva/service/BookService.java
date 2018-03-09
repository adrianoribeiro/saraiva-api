package br.com.saraiva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.saraiva.exceptions.SkuAlreadyExistsException;
import br.com.saraiva.exceptions.SkuNotFoundException;
import br.com.saraiva.model.Book;
import br.com.saraiva.model.stub.BookStub;
import br.com.saraiva.repository.BookRepository;
import br.com.saraiva.util.ApiUtil;
import br.com.saraiva.util.BookConverterUtil;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;

	public Book save(final String sku) {
		
		if(findOne(sku) != null) {
			throw new SkuAlreadyExistsException();
		}
		
		BookStub bookStub = ApiUtil.callApi(sku);
		
		Book book = BookConverterUtil.bookStubToBook(bookStub);
		
		return repository.save(book);	
	}

	public Book findOne(final String sku) {
		
		return repository.findBySku(sku);
	}

	public void delete(final String sku) {
		
		Book book = findOne(sku);
		if(book == null) {
			throw new SkuNotFoundException();
		}
		repository.delete(book);
	}

	public Page<Book> findAll(final Specification spec, final Pageable pageable) {
		
		return repository.findAll(spec, pageable);
	} 
}
