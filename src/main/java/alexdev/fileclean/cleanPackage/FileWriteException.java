package alexdev.fileclean.cleanPackage;

public class FileWriteException extends RuntimeException {
    public FileWriteException() {
    }

    public FileWriteException(String message) {
        super(message);
    }

    public FileWriteException(String message, Throwable cause) {
        super(message, cause);
    }
}
