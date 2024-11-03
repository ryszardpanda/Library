package com.ryszardpanda.Library.service;

import com.ryszardpanda.Library.model.BookStats;
import com.ryszardpanda.Library.repository.BookRepository;
import com.ryszardpanda.Library.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.ryszardpanda.Library.model.Book;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book addBook(Book book){
        return bookRepository.addBook(book);
    }

    public List<Book> getBooks(){
        return bookRepository.getAllBooks();
    }

    public Book getBookById(Integer id){
        return bookRepository.getBookById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nie znaleziono książki o takim ID", HttpStatus.NOT_FOUND));
    }

    public Book updateBook(Integer id, Book updatedBook){
        return bookRepository.updateBookById(id, updatedBook)
                .orElseThrow(() -> new  ResourceNotFoundException("Nie znaleziono książki o takim ID", HttpStatus.NOT_FOUND));
    }

    public boolean deleteBookById(Integer id){
        if (!bookRepository.deleteBookById(id)){
            throw new ResourceNotFoundException("Nie znaleziono książki o takim ID", HttpStatus.NOT_FOUND);
        }
        return bookRepository.deleteBookById(id);
    }

    public List<Book> searchBooksByTitle(String title){
        return bookRepository.searchBooksByTitle(title);
    }

    public List<Book> searchBookByAuthorAndYear(String author, Integer year){
        return bookRepository.searchBooksByAuthorOrYear(author, year);
    }

    public Book updateRating(Integer id, Book updatedRating){
        return bookRepository.updateRating(id, updatedRating)
                .orElseThrow(() -> new ResourceNotFoundException("Nie znaleziono książki o takim ID", HttpStatus.NOT_FOUND));
    }

    public List<Book> getTopRanking(Integer limit){
        return bookRepository.getTopRanking(limit);
    }

    public BookStats getBookStats(){
        return bookRepository.getBookStats();
    }
}
