package classesExercise_BookManagement;

import java.util.Arrays;
import java.math.BigDecimal;

public class Book {
    private int id;
    private String name;
    private Author[] authors;
    private Publisher publisher;
    private int publishingYear;
    private int amountOfPages;
    private BigDecimal price;
    private CoverType coverType;

    public Book(int id, String name, Author[] authors, Publisher publisher, int publishingYear, int amountOfPages,
            BigDecimal price, CoverType coverType) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.publishingYear = publishingYear;
        this.amountOfPages = amountOfPages;
        this.price = price;
        this.coverType = coverType;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", name=" + name + ", authors=" + Arrays.toString(authors) + ", publisher="
                + publisher + ", publishingYear=" + publishingYear + ", amountOfPages=" + amountOfPages + ", price="
                + price + ", coverType=" + coverType + '}';
    }

    public Author getAuthor(int id) {
        for (Author author : authors) {
            if (author.getId() == id) {
                return author;
            }
        }
        return null;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public int getPublishingYear() {
        return publishingYear;
    }
}
