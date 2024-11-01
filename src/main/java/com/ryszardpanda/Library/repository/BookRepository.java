package com.ryszardpanda.Library.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import com.ryszardpanda.Library.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookRepository {

    private final List<Book> books;

    public Book addBook(Book book){
        book.setId(books.size() + 1);
        books.add(book);
        return book;
    }

    public List<Book> getAllBooks(){
        return new ArrayList<>(books);
    }

    public Optional<Book> getBookById(Integer id) {
        if (id == null) {
            return Optional.empty();
        }
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }

    public Optional<Book> updateBookById(Integer id, Book updatedBook){
        Optional<Book> optionalBook = getBookById(id);
        optionalBook.ifPresent(book -> {
            book.setBookTitle(updatedBook.getBookTitle());
            book.setBookAuthor(updatedBook.getBookAuthor());
            book.setPublishYear(updatedBook.getPublishYear());
            book.setRating(updatedBook.getRating());
        });
        return optionalBook;
    }

    public boolean deleteBookById(Integer id){
        return books.removeIf(book -> book.getId().equals(id));
    }

}
