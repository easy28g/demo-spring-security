package com.example.demosecurity.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String text;
    private String tag;

    public Message(){

    }

    public Message(String text, String tag){
        this.text=text;
        this.tag=tag;
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
}
