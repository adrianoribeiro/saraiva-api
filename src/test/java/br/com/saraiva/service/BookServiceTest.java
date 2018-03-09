package br.com.saraiva.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import br.com.saraiva.exceptions.SkuAlreadyExistsException;
import br.com.saraiva.exceptions.SkuNotFoundException;
import br.com.saraiva.model.Book;
import br.com.saraiva.repository.BookRepository;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

	@InjectMocks
	private BookService service;
	
	@Mock
	private BookRepository repository;
	
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
	public void saveSuccess() {
		
		doReturn(book).when(repository).save(any(Book.class));
		
		Book bookSaved = service.save(book.getSku());
		
		assertEquals(bookSaved.getSku(), book.getSku());
	}
	
	@Test(expected=SkuAlreadyExistsException.class)
	public void saveFailure() {
		
		doReturn(book).when(repository).save(any(Book.class));
		doReturn(book).when(repository).findBySku(book.getSku());
		
		service.save(book.getSku());
	}
	
	@Test
	public void findOne() {
		
		doReturn(book).when(repository).save(any(Book.class));
		doReturn(book).when(repository).findBySku(book.getSku());
		
		Book bookFound = service.findOne(book.getSku());
		
		assertEquals(bookFound.getSku(), book.getSku());
	}
	
	@Test
	public void deleteSuccess() {
		
		doNothing().when(repository).delete(any(Book.class));
		doReturn(book).when(repository).findBySku(book.getSku());
		
		service.delete(book.getSku());
		
		verify(repository).delete(any(Book.class));
	}
	
	@Test(expected=SkuNotFoundException.class)
	public void deleteFailure() {
		
		doNothing().when(repository).delete(any(Book.class));
		
		service.delete(book.getSku());
	}
	
	@Test
	public void findAll() {
		
		List<Book> books = new ArrayList<>();
		books.add(book);
		books.add(book);
		
		Page<Book> pageBook = new PageImpl<>(books);
		
		doReturn(pageBook).when(repository).findAll(
				any(Specification.class)
				,any(Pageable.class));
		
		List<Book> booksReturned = service.findAll(any(Specification.class)
				,any(Pageable.class)).getContent();
		
		assertEquals(booksReturned.size(), 2);
	}
}
