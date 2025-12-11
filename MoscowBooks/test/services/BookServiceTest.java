package services;

import data.models.Book;
import data.repositories.BookRepositoriesImpl;
import data.repositories.BooksRepository;
import dtos.requests.AddBookRequest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookServiceTest  {

    Book book;
    AddBookRequest addBookRequest;
    BooksRepository booksRepository;
    BookService bookService;
    @Before
    public void setUp(){addBookRequest = new AddBookRequest();
        bookService = new BookServiceImpl();
        booksRepository = new BookRepositoriesImpl();
        addBookRequest = new AddBookRequest();
    }
    @Test
    public void SaveBookCountIsOne_Test(){
      addBookRequest.setBookAuthor("Chinua Achebe");
      addBookRequest.setBookName("Things Fall Apart");
      addBookRequest.setEdition("first");
      addBookRequest.setDescription("A book about Ikemefula");
      addBookRequest.setQuantity("one");
      bookService.addBook(addBookRequest);
      assertEquals(0, booksRepository.count());

    }

    @Test
    public void SaveBookCountIsTwo_Test(){

    }

}