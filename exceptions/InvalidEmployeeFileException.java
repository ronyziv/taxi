package exceptions;

public class InvalidEmployeeFileException extends Exception {
    public InvalidEmployeeFileException(String message) {
        super(message);
    }
}
