package View;

import bridge.UpAndDown;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String RESTART = "R";
    private static final String QUIT = "Q";
    private Pattern pattern = Pattern.compile("^[0-9]*?");
    private static final int MIN_RANGE = 3;
    private static final int MAX_RANGE = 20;
    private final String errorNumberMessage = "[ERROR] 3이상 20 이하의 숫자를 입력해주세요.";
    private final String errorDirectionMessage = "[ERROR] U 또는 D를 입력해주세요.";
    private final String errorGameCommandMessage = "[ERROR] R 또는 Q를 입력해주세요.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        validateBridgeSize(input);
        return Integer.parseInt(input);
    }

    public void validateBridgeSize(String input){
        validateNotNumber(input);
        validateRange(input);
    }

    public void validateNotNumber(String input){
        if(!pattern.matcher(input).matches()){
            throw new NumberFormatException(errorNumberMessage);
        }
    }

    public void validateRange(String input){
        int bridgeSize = Integer.parseInt(input);
        if(bridgeSize < MIN_RANGE || bridgeSize > MAX_RANGE){
            throw new IllegalArgumentException(errorNumberMessage);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String movingBlock = Console.readLine();
        validateMovingBlockInput(movingBlock);
        return movingBlock;
    }

    void validateMovingBlockInput(String movingBlock){
        if(!isMovingBlockInputValid(movingBlock)){
            throw new IllegalArgumentException(errorDirectionMessage);
        }
    }
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = Console.readLine();
        validateGameCommand(gameCommand);
        return gameCommand;
    }

    void validateGameCommand(String gameCommand){
        if(!isGameCommandInputValid(gameCommand)){
            throw new IllegalArgumentException(errorGameCommandMessage);
        }
    }

    public boolean isMovingBlockInputValid(String movingBlock){
        for(UpAndDown upAndDown : UpAndDown.values()){
            if(upAndDown.isEqualDirection(movingBlock)){
                return true;
            }
        }
        return false;
    }

    public boolean isGameCommandInputValid(String gameCommand){
        if(gameCommand.equals(RESTART) || gameCommand.equals(QUIT)){
            return true;
        }
        return false;
    }
}
