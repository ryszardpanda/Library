package com.ryszardpanda.Library.mapper;

import com.ryszardpanda.Library.model.Book;
import com.ryszardpanda.Library.model.BookDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-03T23:44:45+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDTO bookToDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        Integer id = null;
        String bookTitle = null;
        String bookAuthor = null;
        Integer publishYear = null;

        id = book.getId();
        bookTitle = book.getBookTitle();
        bookAuthor = book.getBookAuthor();
        publishYear = book.getPublishYear();

        BookDTO bookDTO = new BookDTO( id, bookTitle, bookAuthor, publishYear );

        return bookDTO;
    }

    @Override
    public List<BookDTO> bookToDTO(List<Book> books) {
        if ( books == null ) {
            return null;
        }

        List<BookDTO> list = new ArrayList<BookDTO>( books.size() );
        for ( Book book : books ) {
            list.add( bookToDTO( book ) );
        }

        return list;
    }
}
