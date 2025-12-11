package data.repositories;

import data.models.Book;

public interface BooksRepository {
    long count();

    int getCount();

    int addBook();

//    int findById(Book book2);

    int findId(Book book2);

    Book findById(int id);

    int delete(int id);

    int deleteById(int id);
    boolean existsById(int id);
    Book save(Book book);

}


