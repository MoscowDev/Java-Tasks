package services;

import data.models.Book;
import data.repositories.BookRepositoriesImpl;
import data.repositories.BooksRepository;
import dtos.requests.AddBookRequest;
import dtos.responses.AddBookResponse;
import utils.Mapper;

public class BookServiceImpl implements BookService {
    BooksRepository bookRepositories = new BookRepositoriesImpl();
    @Override
    public AddBookResponse addBook(AddBookRequest request) {
        bookRepositories.save(Mapper.mapRequest(request));
        return new AddBookResponse();

    }
}
