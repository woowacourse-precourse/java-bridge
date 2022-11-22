package bridge.Model;

public class GameCommandValidator implements Validator{

    private static final String ERROR_NON_EXISTENT_COMMAND = "[ERROR] 올바르지 않은 명령입니다.";

    public void validate(String input){
        if (!input.equals("R") && !input.equals("Q")){
            throw new IllegalArgumentException(ERROR_NON_EXISTENT_COMMAND);
        }
    }
}
