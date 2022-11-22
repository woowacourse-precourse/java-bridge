package bridge;

public class RetryCommandException extends IllegalArgumentException{
    public RetryCommandException(String s) {
        super(s);
    }
}
