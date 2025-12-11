package data.models;

import data.repositories.BookRepositoriesImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class BookTest {
    BookRepositoriesImpl bookRepositories;
    Book book;
    @Before
    public void setUp() {
        bookRepositories = new BookRepositoriesImpl();
    }
    @After
    public void tearDown() {
        bookRepositories.deleteAll();
    }

    @Test
    public void new_Book_Repositories_IsEmpty_Test() {
        bookRepositories.getCount();
        Assert.assertEquals(0, bookRepositories.getCount());
    }

    @Test
    public void SaveBookCountIsOne_Test() {
        Book book = new Book();
        bookRepositories.save(book);
        Assert.assertEquals(1L, bookRepositories. getCount());

    }
    @Test
    public void saveBook_bookIdIsSet_Test() {
        Book book = new Book();
        bookRepositories.save(book);
        Assert.assertEquals(1 , bookRepositories.findId(book));
    }

    @Test
    public void saveBookA_FindBookB_return_null_Test() {
        Book book = new Book();
        bookRepositories.save(book);
        assertNull(bookRepositories.findById(2));

    }
    @Test
    public void SaveBook_Book_Is_Returned_Test() {
        Book book = new Book();
        Assert.assertEquals(book, bookRepositories.save(book));

    }

    @Test
    public void SaveBook_FindBookById_returnBook_Test() {
        Book book = new Book();
        bookRepositories.save(book);
        Assert.assertEquals(book, bookRepositories.findById(1));
    }

    @Test
    public void SaveBook_Book_Id_IsNotZero_Test() {
        Book book = new Book();
        bookRepositories.save(book);
        bookRepositories.save(book);
        bookRepositories.save(book);
        Assert.assertEquals(3L, bookRepositories. getCount());

    }
    @Test
    public void saveBook_existsById_Test() {
        Book book = new Book();
        bookRepositories.save(book);
        assertTrue(bookRepositories.existsById(1));
    }

    @Test
    public void SaveBook_CountIsOne_DeleteById_BookCountIsZero_Test() {
        Book book = new Book();
        bookRepositories.save(book);
        Assert.assertEquals(1L, bookRepositories.getCount());
        bookRepositories.deleteById(1);
        Assert.assertEquals(0L, bookRepositories.getCount());

    }

    @Test
    public void SaveBooks_deleteAll_Test() {
        Book book = new Book();
        bookRepositories.save(book);
        bookRepositories.save(book);
        bookRepositories.save(book);
        bookRepositories.deleteAll();
        Assert.assertEquals(0L, bookRepositories.getCount());
    }









}