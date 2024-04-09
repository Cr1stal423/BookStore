package com.cr1stal423.bookstore.controller;

import com.cr1stal423.bookstore.entity.Book;
import com.cr1stal423.bookstore.entity.MyBook;
import com.cr1stal423.bookstore.service.BookService;
import com.cr1stal423.bookstore.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private MyBookService myBookService;

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBook(){
        List<Book> list = bookService.getAllBook();
        return new ModelAndView("bookList","book",list);
    }
    @GetMapping("/my_books")
    public String getMyBooks(Model model){
        List<MyBook> myBookList = myBookService.getAllBook();
        model.addAttribute("book",myBookList);
        return "myBooks";
    }
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book){
        bookService.save(book);
        return "redirect:/available_books";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Book b=bookService.getBook(id);
        MyBook mb=new MyBook(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        myBookService.save(mb);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id,Model model) {
        Book b=bookService.getBook(id);
        model.addAttribute("book",b);
        return "bookEdit";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id")int id) {
        bookService.deleteBook(id);
        return "redirect:/available_books";
    }

}
