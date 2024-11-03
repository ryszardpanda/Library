package com.ryszardpanda.Library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    private Integer id;
    private String bookTitle;
    private String bookAuthor;
    private Integer publishYear;
    private double rating;

    public void setRating(Double rating) {
        if (rating != null && (rating < 1.0 || rating > 5.0)) {
            throw new IllegalArgumentException("Rating must be between 1.0 and 5.0");
        }
        this.rating = rating;
    }
}
