package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping("/")
    public String listBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String bookForm(Model model){
        model.addAttribute("book", new Book());
        return "bookform";

    }

    @PostMapping("/process")
    public String processForm(@Valid @ModelAttribute Book book, BindingResult result){
        if (result.hasErrors()){
            return "bookform";
        }
        if (book.getIsInStock()==false){
            book.setNumberOfBooks(0);
        }
        bookRepository.save(book);
        return "redirect:/";

    }

    @RequestMapping("/detail/{id}")
    public String showBook(@PathVariable("id") long id, Model model){
        model.addAttribute("book", bookRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateBook(@PathVariable("id") long id, Model model){
        model.addAttribute("book", bookRepository.findById(id).get());
        return "bookform";
    }

    @RequestMapping("/delete/{id}")
    public String delBook(@PathVariable("id") long id){
        bookRepository.deleteById(id);
        return "redirect:/";
    }
}
