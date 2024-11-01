package com.ryszardpanda.Library.controller;

import com.ryszardpanda.Library.model.BookStats;
import com.ryszardpanda.Library.repository.BookRepository;
import com.ryszardpanda.Library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.ryszardpanda.Library.model.Book;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final BookRepository bookRepository;

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book updatedBook){
        return bookService.updateBook(id, updatedBook);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBookById(@PathVariable Integer id){
        boolean deletedBook = bookService.deleteBookById(id);
    }

    @GetMapping("/books/search")
    public List<Book> searchBooksByTitle(@RequestParam String title) {
        return bookService.searchBooksByTitle(title);
    }

    @GetMapping("/books/searchByAuthor")
    public List<Book> searchBookByAuthorAndYear(@RequestParam (required = false) String author, @RequestParam (required = false) Integer year) {
        return bookService.searchBookByAuthorAndYear(author, year);
    }

    @PutMapping("books/updateRating")
    public Book updateRating(@RequestParam Integer id, @RequestBody Book rating){
        return bookService.updateRating(id, rating);
    }

    @GetMapping("books/getTopRanking")
    public List<Book> getTopRanking(@RequestParam Integer limit){
        return bookService.getTopRanking(limit);
    }

    @GetMapping("books/stats")
    public BookStats getBookStats(){
        return bookService.getBookStats();
    }

}
