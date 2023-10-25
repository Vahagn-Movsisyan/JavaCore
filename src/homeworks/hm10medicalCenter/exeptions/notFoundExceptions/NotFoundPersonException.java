package homeworks.hm10medicalCenter.exeptions.notFoundExceptions;

public class NotFoundPersonException extends Exception {

    public NotFoundPersonException() {
    }

    public NotFoundPersonException(String message) {
        super(message);
    }

    public NotFoundPersonException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundPersonException(Throwable cause) {
        super(cause);
    }

    public NotFoundPersonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
