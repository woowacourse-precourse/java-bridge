package bridge;

import static bridge.Constants.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String tempBridgeSize = "";
        while(true) {
            try {
                tempBridgeSize = readLine();
                bridgeValidate(tempBridgeSize);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                continue;
            }
            break;
        }
        int bridgeSize = Integer.parseInt(tempBridgeSize);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = "";
        while(true) {
            try {
                move = readLine();
                movingValidate(move);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                continue;
            }
            break;
        }
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = "";
        while(true) {
            try {
                command = readLine();
                commandValidate(command);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                continue;
            }
            break;
        }
        return command;
    }

    void bridgeValidate(String bridgeSize){
        if(!isNumber(bridgeSize)){
            System.out.println(ERROR_PREFIX + BRIDGE_ERROR);
            throw new IllegalArgumentException(ERROR_PREFIX + BRIDGE_ERROR);
        }
        int convertedBridgeSize = Integer.parseInt(bridgeSize);
        if(convertedBridgeSize < SMALLEST_BRIDGE || convertedBridgeSize > BIGGEST_BRIDGE){
            System.out.println(ERROR_PREFIX + BRIDGE_ERROR);
            throw new IllegalArgumentException(ERROR_PREFIX + BRIDGE_ERROR);

        }
    }

    boolean isNumber(String bridgeSize){
        boolean answer = true;
        for(int idx = 0; idx < bridgeSize.length(); idx++){
            if(!Character.isDigit(bridgeSize.charAt(idx))){
                answer = false;
            }
        }
        return answer;
    }

    void movingValidate(String move){
        if(!move.equals("U") && !move.equals("D")){
            System.out.println(ERROR_PREFIX + MOVE_ERROR);
            throw new IllegalArgumentException(ERROR_PREFIX + MOVE_ERROR);
        }
    }

    void commandValidate(String command){
        if(!command.equals(RETRY) && !command.equals(QUIT)){
            System.out.println(ERROR_PREFIX + COMMAND_ERROR);
            throw new IllegalArgumentException(ERROR_PREFIX + COMMAND_ERROR);
        }
    }
}
