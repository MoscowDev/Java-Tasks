package utils;

import data.models.Book;
import dtos.requests.AddBookRequest;


public class Mapper {
    public static Book mapRequest(AddBookRequest addBookRequest){
        Book myBook = new Book();
        myBook.setAuthor(addBookRequest.getBookAuthor());
        myBook.setDescription(addBookRequest.getDescription());
        myBook.setTitle(myBook.getTitle());
        myBook.setQuantity(myBook.getQuantity());
        return myBook;


    }
}
