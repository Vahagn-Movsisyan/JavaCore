package homeworks.hm10medicalCenter.exeptions;

public class DoublePersonFoundException  extends Exception {
    public DoublePersonFoundException() {
    }

    public DoublePersonFoundException(String message) {
        super(message);
    }

    public DoublePersonFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DoublePersonFoundException(Throwable cause) {
        super(cause);
    }

    public DoublePersonFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
