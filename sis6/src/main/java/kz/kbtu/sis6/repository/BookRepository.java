package kz.kbtu.sis6.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import kz.kbtu.sis6.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
    Page<Book> findAll(Pageable pageable);
}
