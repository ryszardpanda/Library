package com.ryszardpanda.Library.repository;

import com.ryszardpanda.Library.model.BookStats;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import com.ryszardpanda.Library.model.Book;

import java.util.*;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class BookRepository {

    private final List<Book> books;

    public Book addBook(Book book) {
        book.setId(books.size() + 1);
        books.add(book);
        return book;
    }

    public List<Book> getAllBooks() {
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

    public Optional<Book> updateBookById(Integer id, Book updatedBook) {
        Optional<Book> optionalBook = getBookById(id);
        optionalBook.ifPresent(book -> {
            book.setBookTitle(updatedBook.getBookTitle());
            book.setBookAuthor(updatedBook.getBookAuthor());
            book.setPublishYear(updatedBook.getPublishYear());
            book.setRating(updatedBook.getRating());
        });
        return optionalBook;
    }

    public boolean deleteBookById(Integer id) {
        return books.removeIf(book -> book.getId().equals(id));
    }

    public List<Book> searchBooksByTitle(String title) {
        return books.stream()
                .filter(book -> book.getBookTitle().contains(title))
                .collect(Collectors.toList());
    }

    public List<Book> searchBooksByAuthorAndYear(String author, Integer year) {
        return books.stream()
                .filter(book -> (author == null || book.getBookAuthor().contains(author)))
                .filter(book -> (year == null || book.getPublishYear().equals(year)))
                .collect(Collectors.toList());
    }

    public Optional<Book> updateRating(Integer id, Book updatedRating) {
        Optional<Book> bookById = getBookById(id);
        bookById.ifPresent(book -> book.setRating(updatedRating.getRating()));
        return bookById;
    }

    public List<Book> getTopRanking(Integer limit) {
        return books.stream().filter(book -> book.getRating() >= 1.0 && book.getRating() <= 5.0)
                .sorted(Comparator.comparingDouble(Book::getRating).reversed())
                .limit(limit)
                .collect(Collectors.toList());
    }

    public BookStats getBookStats() {
        DoubleSummaryStatistics ratingStats = books.stream()
                .filter(book -> book.getRating() >= 1.0 && book.getRating() <= 5.0)
                .mapToDouble(Book::getRating)
                .summaryStatistics();

        int totalBooks = books.size();
        int uniqueAuthors = (int) books.stream() // count zwróci nam longa, więc musimy przekonwertować na int
                .map(Book::getBookAuthor)
                .distinct()
                .count();

        return new BookStats(
                ratingStats.getAverage(),
                totalBooks,
                uniqueAuthors
        );
    }
}
