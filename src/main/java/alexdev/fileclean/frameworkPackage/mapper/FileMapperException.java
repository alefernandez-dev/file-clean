package alexdev.fileclean.frameworkPackage.mapper;

public class FileMapperException extends RuntimeException {
    public FileMapperException() {
    }

    public FileMapperException(String message) {
        super(message);
    }

    public FileMapperException(String message, Throwable cause) {
        super(message, cause);
    }
}
