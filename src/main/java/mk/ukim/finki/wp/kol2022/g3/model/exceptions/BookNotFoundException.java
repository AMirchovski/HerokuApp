package mk.ukim.finki.wp.kol2022.g3.model.exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(Long id){
        super(String.format("Book with id: %d not found", id));
    }
}
