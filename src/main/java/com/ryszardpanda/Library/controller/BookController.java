package com.ryszardpanda.Library.controller;

import com.ryszardpanda.Library.mapper.BookMapper;
import com.ryszardpanda.Library.model.BookDTO;
import com.ryszardpanda.Library.model.BookStats;
import com.ryszardpanda.Library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.ryszardpanda.Library.model.Book;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final BookMapper bookMapper;

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO addBook(@RequestBody Book book) {
        return bookMapper.bookToDTO(bookService.addBook(book));
    }

    @GetMapping("/books")
    public List<BookDTO> getBooks(){
        return bookService.getBooks().stream()
                .map(bookMapper::bookToDTO)
                .toList();
    }

    @GetMapping("/books/{id}")
    public BookDTO getBookById(@PathVariable Integer id) {
        return bookMapper.bookToDTO(bookService.getBookById(id));
    }

    @PutMapping("/books/{id}")
    public BookDTO updateBook(@PathVariable Integer id, @RequestBody Book updatedBook){
        return bookMapper.bookToDTO(bookService.updateBook(id, updatedBook));
    }

    @DeleteMapping("/books/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteBookById(@PathVariable Integer id){
        boolean deletedBook = bookService.deleteBookById(id);
    }

    @GetMapping("/books/search")
    public List<BookDTO> searchBooksByTitle(@RequestParam String title) {
        return bookMapper.bookToDTO(bookService.searchBooksByTitle(title));
    }

    @GetMapping("/books/searchByAuthor")
    public List<BookDTO> searchBookByAuthorAndYear(@RequestParam (required = false) String author, @RequestParam (required = false) Integer year) {
        return bookMapper.bookToDTO(bookService.searchBookByAuthorAndYear(author, year));
    }

    @PatchMapping("books/updateRating")
    public BookDTO updateRating(@RequestParam Integer id, @RequestBody Book rating){
        return bookMapper.bookToDTO(bookService.updateRating(id, rating));
    }

    @GetMapping("books/getTopRanking")
    public List<BookDTO> getTopRanking(@RequestParam Integer limit){
        return bookMapper.bookToDTO(bookService.getTopRanking(limit));
    }

    @GetMapping("books/stats")
    public BookStats getBookStats(){
        return bookService.getBookStats();
    }
}
