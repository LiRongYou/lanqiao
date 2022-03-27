package Exception异常;
/**
* 自定义异常类
**/
public class UserExceptiom extends Exception {
    public UserExceptiom() {
        super();
    }

    public UserExceptiom(String message) {
        super(message);
    }

    public UserExceptiom(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExceptiom(Throwable cause) {
        super(cause);
    }

    protected UserExceptiom(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
