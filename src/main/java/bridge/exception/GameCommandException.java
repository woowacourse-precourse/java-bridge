package bridge.exception;

import static bridge.enums.GameStatus.*;

public class GameCommandException extends Exceptions{private static final String NOT_GIVEN_OPINION_COMMENT = "개임은 R을 통해 재시작, Q를 통해 종료할 수 있습니다. R 또는 Q를 입력해주세요.";

    public String validate(String input){
        if(isNotQuit(input) && isNotRestart(input)) notGivenOpinionException();
        return input;
    }

    private boolean isNotRestart(String input){
        return !input.equals(START.getCommand());
    }

    private boolean isNotQuit(String input){
        return !input.equals(QUIT.getCommand());
    }

    private void notGivenOpinionException(){
        executeException(NOT_GIVEN_OPINION_COMMENT);
    }
}
