package br.com.saraiva.util;

import java.math.BigDecimal;

import br.com.saraiva.model.Book;
import br.com.saraiva.model.stub.BookStub;

public final class BookConverterUtil {

	public static Book bookStubToBook(final BookStub bookStub) {
		final Book book = new Book();
		book.setBrand(bookStub.getBrand());
		book.setName(bookStub.getName());
		
		String priceValue = bookStub.getPrice().getBestPrice().getValue().replace(",", ".");
		book.setPrice(new BigDecimal(priceValue));
		book.setSku(bookStub.getSku());
		return book;
	}
	
}