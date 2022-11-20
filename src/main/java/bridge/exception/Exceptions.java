package bridge.exception;

public class Exceptions {

    private static final String ERROR_COMMENT = "[ERROR] ";

    private void executeException(String comment){
        System.out.println(ERROR_COMMENT + comment);
    }
}
