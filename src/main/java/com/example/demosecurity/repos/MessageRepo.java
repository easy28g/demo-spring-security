package com.example.demosecurity.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demosecurity.domains.Message;

public interface MessageRepo extends CrudRepository<Message, Integer>{

    List<Message> findByTag(String tag);
} 