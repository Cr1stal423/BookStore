package com.cr1stal423.bookstore.repository;

import com.cr1stal423.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
