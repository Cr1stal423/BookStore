package com.cr1stal423.bookstore.service;

import com.cr1stal423.bookstore.entity.Book;
import com.cr1stal423.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public void save(Book book){
        bookRepository.save(book);
    }

    public void deleteBook(int id){
        bookRepository.deleteById(id);
    }

    public Book getBook(int id){
       return bookRepository.findById(id).get();
    }

    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }
}
