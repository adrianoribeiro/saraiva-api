package br.com.saraiva.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.saraiva.model.Book;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long>, JpaSpecificationExecutor{

	Book findBySku(String sku);

}
