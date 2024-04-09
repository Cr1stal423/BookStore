package com.cr1stal423.bookstore.repository;

import com.cr1stal423.bookstore.entity.MyBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyBookRepository extends JpaRepository<MyBook,Integer> {
}
