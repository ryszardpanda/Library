package com.ryszardpanda.Library.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BookDTO {
    private Integer id;
    private String bookTitle;
    private String bookAuthor;
    private Integer publishYear;
   // private double rating;
}
