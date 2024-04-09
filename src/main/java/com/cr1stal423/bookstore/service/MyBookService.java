package com.cr1stal423.bookstore.service;

import com.cr1stal423.bookstore.entity.Book;
import com.cr1stal423.bookstore.entity.MyBook;
import com.cr1stal423.bookstore.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookService {
    @Autowired
    MyBookRepository myBookRepository;

    public void save(MyBook book){
        myBookRepository.save(book);
    }

    public void delete(int id){
        myBookRepository.deleteById(id);
    }

    public List<MyBook> getAllBook(){
        return myBookRepository.findAll();
    }

    public MyBook getBook(int id){
        return myBookRepository.findById(id).get();
    }
}
