package homeworks.hm10medicalCenter.exeptions.validationExceptions.phoneValidation;

public class InvalidPhoneNumberFormatException extends Exception {
    public InvalidPhoneNumberFormatException() {
    }

    public InvalidPhoneNumberFormatException(String message) {
        super(message);
    }

    public InvalidPhoneNumberFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPhoneNumberFormatException(Throwable cause) {
        super(cause);
    }

    public InvalidPhoneNumberFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
