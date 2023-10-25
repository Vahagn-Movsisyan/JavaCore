package homeworks.hm10medicalCenter.exeptions.validationExceptions.emailValidation;

public class IncorrectFormatEmailException extends Exception {
    public IncorrectFormatEmailException() {
    }

    public IncorrectFormatEmailException(String message) {
        super(message);
    }

    public IncorrectFormatEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectFormatEmailException(Throwable cause) {
        super(cause);
    }

    public IncorrectFormatEmailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
