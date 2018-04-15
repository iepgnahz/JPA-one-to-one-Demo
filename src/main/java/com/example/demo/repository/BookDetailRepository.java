package com.example.demo.repository;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.BookDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookDetailRepository extends JpaRepository<BookDetail, Long> {
    Optional<BookDetail> findById(Long id);
}
