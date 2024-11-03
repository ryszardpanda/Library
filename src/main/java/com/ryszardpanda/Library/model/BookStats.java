package com.ryszardpanda.Library.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookStats {
    private double averageRating;
    private int totalBooks;
    private int uniqueAuthors;
}