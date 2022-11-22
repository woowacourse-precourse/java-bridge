package bridge;

import java.util.PrimitiveIterator;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final String READ_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private final String READ_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String READ_GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final String ERROR_NOT_NUMBER_MESSAGE = "[ERROR] 숫자만 입력을 받습니다." ;
    private final String ERROR_SCOPE_NUMBER_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private final String ERROR_MOVING_COMMAND_MESSAGE = "[ERROR] U와 D 중에 하나를 입력하세요.";
    private final String ERROR_GAME_COMMAND_MESSAGE = "[ERROR] R와 Q 중에 하나를 입력하세요.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(READ_BRIDGE_SIZE_MESSAGE);
        String bridgeSize = readLine();
        try{
            readBridgeSizeOfNoNumberException(bridgeSize);
            readScopeOfBridgeSizeOfNumberException(bridgeSize);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            bridgeSize = String.valueOf(readBridgeSize());
        }
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(READ_MOVING_MESSAGE);
        String userAnswer = readLine();
        try{
            readMovingCommandCheck(userAnswer);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            userAnswer = readMoving();
        }
        return userAnswer.toUpperCase();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(READ_GAME_COMMAND_MESSAGE);
        String userCommand = readLine();
        try{
            readGameCommandCheck(userCommand);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            userCommand = readGameCommand();
        }
        return userCommand.toUpperCase();
    }

    public void readBridgeSizeOfNoNumberException(String bridgeSize){
        String brideSizeRegularExpression = "^\\d{1,2}$";
        if(!bridgeSize.matches(brideSizeRegularExpression)){
            throw new IllegalArgumentException(ERROR_NOT_NUMBER_MESSAGE);
        }
    }

    public void readScopeOfBridgeSizeOfNumberException(String bridgeSize){
        int size = Integer.parseInt(bridgeSize);
        if(size<3 || size>20){
            throw new IllegalArgumentException(ERROR_SCOPE_NUMBER_MESSAGE);
        }
    }

    public void readMovingCommandCheck(String userCommand){
        String moveCommandRegularExpression = "^[U|D]{1}$";
        if(!userCommand.matches(moveCommandRegularExpression)){
            throw new IllegalArgumentException(ERROR_MOVING_COMMAND_MESSAGE);
        }
    }

    public void readGameCommandCheck(String userAnswer){
        String readGameCommandCheck = "^[Q|q|R|r]$";
        if(!userAnswer.matches(readGameCommandCheck)){
            throw new IllegalArgumentException(ERROR_GAME_COMMAND_MESSAGE);
        }
    }
}
