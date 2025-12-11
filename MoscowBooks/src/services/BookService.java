package services;

import dtos.requests.AddBookRequest;
import dtos.responses.AddBookResponse;

public interface BookService {
    AddBookResponse addBook(AddBookRequest request);

}
