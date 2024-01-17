package com.example.demo.service;

import com.example.demo.mapper.BookMapper;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private BookMapper mapper;


}
