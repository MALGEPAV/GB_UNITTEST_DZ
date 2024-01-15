package seminars.fourth.book;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {
    BookRepository mockBookRepository;
    BookService bookService;
    Book book;
    List<Book> bookList;

    @BeforeEach
    void setUp() {
        mockBookRepository = mock(BookRepository.class);
        bookService = new BookService(mockBookRepository);
        book = new Book("123", "Title", "Author");
        bookList = List.of(book);
    }

    @Test
    void bookServiceReturnsRightBookById() {
        when(mockBookRepository.findById("123")).thenReturn(book);

        Book resultBook = bookService.findBookById("123");

        assertEquals(book, resultBook);
    }

    @Test
    void setBookServiceReturnsRightBookList() {
        when(mockBookRepository.findAll()).thenReturn(bookList);

        List<Book> resultList = bookService.findAllBooks();

        assertEquals(bookList, resultList);
    }
}