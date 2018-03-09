package br.com.saraiva.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import br.com.saraiva.model.Book;
import br.com.saraiva.service.BookService;

@RunWith(PowerMockRunner.class)
public class BookControllerTest {

	@InjectMocks
	private BookController controller;
	
	@Mock
	private BookService service;
	
	private Book book;
	
	@Before
	public void setUp() throws Exception {
		book = new Book();
		book.setSku("9731880");
		book.setBrand("Arqueiro");
		book.setName("Origem");
		book.setPrice(new BigDecimal("39.90"));
	}
	
	@Test
	public void saveComSucesso(){
		
		controller.create(book.getSku());
		verify(service).save(book.getSku());
	}
	
	@Test
	public void findOne(){
		controller.findOne(this.book.getSku());
		verify(service).findOne(this.book.getSku());
	}
	
	@Test
	public void findAll(){
		
		controller.findAll(any(Book.class)
				,any(Pageable.class));
		
		verify(service).findAll(any(Specification.class)
				,any(Pageable.class));
	}
	
	@Test
	public void delete(){
		controller.delete(this.book.getSku());
		verify(service).delete(this.book.getSku());
	}

}
