package homeworks.hm10medicalCenter.exeptions.validationExceptions.phoneValidation;

public class DoublePhoneNumberFoundException extends  Exception {
    public DoublePhoneNumberFoundException() {
    }

    public DoublePhoneNumberFoundException(String message) {
        super(message);
    }

    public DoublePhoneNumberFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DoublePhoneNumberFoundException(Throwable cause) {
        super(cause);
    }

    public DoublePhoneNumberFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
