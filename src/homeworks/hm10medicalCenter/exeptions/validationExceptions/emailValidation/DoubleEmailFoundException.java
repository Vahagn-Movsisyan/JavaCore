package homeworks.hm10medicalCenter.exeptions.validationExceptions.emailValidation;

public class DoubleEmailFoundException extends Exception {
    public DoubleEmailFoundException() {
    }

    public DoubleEmailFoundException(String message) {
        super(message);
    }

    public DoubleEmailFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DoubleEmailFoundException(Throwable cause) {
        super(cause);
    }

    public DoubleEmailFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
