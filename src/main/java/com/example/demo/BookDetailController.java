package com.example.demo;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.BookDetail;
import com.example.demo.repository.BookDetailRepository;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(path = "/bookDetails")
public class BookDetailController {
    @Autowired
    private BookDetailRepository bookDetailRepository;

    @GetMapping(value = "/{id}")
    ResponseEntity<?> get(@PathVariable Long id){
        Optional<BookDetail> bookDetail = bookDetailRepository.findById(id);
        return bookDetail.<ResponseEntity<?>>map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        //该get证明可以进行级联查询
    }

    @PostMapping(value = "")
    ResponseEntity<?> add(@RequestBody BookDetail input){
        Book book = new Book();
        input.setBook(book);
        BookDetail createdBookDetail = bookDetailRepository.save(input);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdBookDetail.getId()).toUri();
        //在当前的request中添加path给的参数，path中的变量将在buildAndExpand给出
        // 由于restful api post请求返回的状态码是201，并且在head里加上location字段
        return ResponseEntity.created(location).build();


        //该post证明可以级联创建
    }



}
