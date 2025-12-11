package data.repositories;

import data.models.Book;

import java.util.ArrayList;

public class BookRepositoriesImpl implements BooksRepository{
    static ArrayList<Book> bookList = new ArrayList<>();
    private int count;
    Book book;

    @Override
    public long count() {
        return 0;
    }

    @Override
    public int getCount() {
        return bookList.size();
    }

    @Override
    public int addBook() {
        return 0;
    }

    @Override
    public int findId(Book book2) {
        return book2.getId();
    }

    @Override
    public Book findById(int id) {
        for(Book book:bookList){
            if(book.getId() == id)return book;
        }
        return null;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

@Override
    public Book save(Book book) {
        count++;
        bookList.add(book);
        bookList.get(count-1)
                .setId(count);
        return book ;
    }

    public int deleteById(int id) {
        validateId(id);
        bookList.remove(id-1);
        return bookList.size();

    }

    private void validateId(int id) {
        if (id <= 0 || id > count) {
            throw new IllegalArgumentException();
        }
    }

    public boolean existsById(int id) {
        return id > 0 && id <= count;
    }

    public void deleteAll() {
        bookList.clear();
    }
}
