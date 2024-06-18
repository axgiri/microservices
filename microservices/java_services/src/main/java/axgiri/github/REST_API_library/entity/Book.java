package axgiri.github.REST_API_library.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

@Builder
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int id;

    private String name;
    private String author;

    public Book(int id, String name, String author){
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public Book(){
    
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    } 

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }
}

