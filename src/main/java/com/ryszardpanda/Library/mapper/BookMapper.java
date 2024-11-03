package com.ryszardpanda.Library.mapper;

import com.ryszardpanda.Library.model.Book;
import com.ryszardpanda.Library.model.BookDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO bookToDTO(Book book);
    List<BookDTO> bookToDTO(List<Book> books);
}
