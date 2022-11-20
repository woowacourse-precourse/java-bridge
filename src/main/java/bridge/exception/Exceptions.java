package bridge.exception;

public class Exceptions {

    private static final String ERROR_COMMENT = "[ERROR] ";

    public void executeException(String comment){
        System.out.println(ERROR_COMMENT + comment);
        throw new IllegalArgumentException();
    }
}
