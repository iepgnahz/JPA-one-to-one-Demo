package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "bookDetail")
public class BookDetail {
    @Id
    @GeneratedValue
    private Long id;

    private String writer;

    @OneToOne(mappedBy = "bookDetail")
    @JsonIgnoreProperties("bookDetail")
    private Book book;

    public BookDetail(String writer) {
        this.writer = writer;
    }

    public BookDetail() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
