package com.cr1stal423.bookstore.controller;

import com.cr1stal423.bookstore.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookController {
    @Autowired
    MyBookService service;

    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable int id){
        service.delete(id);
        return "redirect:/my_books";
    }
}
