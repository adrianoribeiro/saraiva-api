package br.com.saraiva.repository.spec;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.saraiva.model.Book;

public class BookSpecification implements Specification<Book>{

	private Book book;

	public BookSpecification(final Book book) {
		this.book = book;
	}

	@Override
	public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		
		final Path sku = root.get("sku");
		final Path name = root.get("name");
		final Path brand = root.get("brand");
		final Path price = root.get("price");
		
		final List<Predicate> predicates = new ArrayList<Predicate>();
		
		this.equalOperator(predicates, cb, sku, book.getSku(), book.getSku() == null);
		this.equalOperator(predicates, cb, name, book.getName(), book.getName() == null);
		this.equalOperator(predicates, cb, brand, book.getBrand(), book.getBrand() == null);
		
		if(book.getPrice() != null) {
			predicates.add(cb.lessThanOrEqualTo(price, book.getPrice()));
		}
		
		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	}
	
	private void equalOperator(List<Predicate> predicates, CriteriaBuilder cb, final Path path, Object value, boolean ignore) {
		if(!ignore && value != null) {
			predicates.add(cb.equal(path, value));
		}
	}
	
	private void equalOperator(List<Predicate> predicates, CriteriaBuilder cb, final Path path, Object value) {
		this.equalOperator(predicates, cb, path, value, false);
	}

}
