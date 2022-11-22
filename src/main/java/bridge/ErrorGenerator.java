package bridge;

public class ErrorGenerator {
    private static final String ERROR_MSG_START="[ERROR] : ";
    public static void errorGenerate(String errorMsg){
        throw new IllegalArgumentException(ERROR_MSG_START+ errorMsg);
    }
}
