package mk.ukim.finki.wp.kol2022.g3.model.exceptions;

public class CountryNotFoundException extends RuntimeException{
    public CountryNotFoundException(Long id){
        super(String.format("Country with id: %d not found", id));
    }
}
