package com.example.demosecurity.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String text;
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    private String filename;

    public Message(){

    }

    public Message(String text, String tag, User author){
        this.text=text;
        this.tag=tag;
        this.author=author;
    }

    public Integer getId(){
        return this.id;
    }

    public void setText(String text){
        this.text = text;
    }
    
    public String getText(){
        return this.text;
    }

    public void setTag(String tag){
        this.tag = tag;
    }
    
    public String getTag(){
        return this.tag;
    }

    public User getAuthor() {
        return this.author;
    }

    public String getAuthorName(){
        return author != null ? author.getUsername() : "<none>";
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

}
