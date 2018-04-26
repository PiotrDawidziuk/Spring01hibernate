package pl.coderslab.model;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NotNull
    @Size(min = 5,message="Wymagane co najmniej 5 znakow")
    String title;

    String author;
    @Min(value = 1, message="Rating nie moze byc mniejszy niz 1")
    @Max(value = 10, message="Rating nie moze byc wiekszy niz 10")
    Integer rating;
    String publisher;
    String description;

    public Book() {
    }

    public Book(String title, String author, Integer rating, String publisher, String description) {
        this.title = title;
        this.author = author;
        this.rating = rating;
        this.publisher = publisher;
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {

        return "Title: " + title + " Rating: " + rating + " Publisher: " + publisher + " Description: " + description;
    }
}
