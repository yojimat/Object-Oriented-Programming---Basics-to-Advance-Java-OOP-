package classesExercise_BookManagement;

import java.util.List;
import java.util.ArrayList;

public class BookService {
	public BookService() {
	}

	public Book[] filterBooksByAuthor(Author author, Book[] books) {
		List<Book> filteredBooks = new ArrayList<Book>();
		for (Book book : books) {
			Author foundAuthor = book.getAuthor(author.getId());
			if (foundAuthor != null && foundAuthor.equals(author)) {
				filteredBooks.add(book);
			}
		}
		return filteredBooks.toArray(new Book[filteredBooks.size()]);
	}

	public Book[] filterBooksByPublisher(Publisher publisher, Book[] books) {
		List<Book> filteredBooks = new ArrayList<Book>();
		for (Book book : books) {
			if (book.getPublisher().equals(publisher)) {
				filteredBooks.add(book);
			}
		}
		return filteredBooks.toArray(new Book[filteredBooks.size()]);
	}

	public Book[] filterBooksAfterSpecifiedYear(int yearFromInclusively, Book[] books) {
		List<Book> filteredBooks = new ArrayList<Book>();
		for (Book book : books) {
			if (book.getPublishingYear() >= yearFromInclusively) {
				filteredBooks.add(book);
			}
		}
		return filteredBooks.toArray(new Book[filteredBooks.size()]);
	}

}