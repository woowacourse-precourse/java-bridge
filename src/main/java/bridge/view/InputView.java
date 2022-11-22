package bridge.view;

import bridge.enums.IntEnum;
import bridge.enums.StringEnum;
import camp.nextstep.edu.missionutils.Console;

import static bridge.enums.IntEnum.*;
import static bridge.enums.StringEnum.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(){
        String bridgeSizeInput = Console.readLine();
        bridgeSizeValidate(bridgeSizeInput);
        return Integer.parseInt(bridgeSizeInput);
    }

    public void bridgeSizeValidate(String bridgeSizeInput){
        bridgeInputDigitValidate(bridgeSizeInput);
        bridgeInputRangeValidate(bridgeSizeInput);
    }

    private void bridgeInputRangeValidate(String bridgeSizeInput) {
        int bridgeSize = Integer.parseInt(bridgeSizeInput);
        if(BRIDGE_START.num()>bridgeSize || BRIDGE_LAST.num()<bridgeSize){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 "+ BRIDGE_START.num()+"부터 "+ BRIDGE_LAST.num()+
                    "사이의 숫자여야 합니다.");
        }
    }

    private void bridgeInputDigitValidate(String bridgeSizeInput) {
        String compareInput = bridgeSizeInput.replaceAll("[0-9]","");
        if(bridgeSizeInput.length() == compareInput.length()){
            throw new IllegalArgumentException("[ERROR] 다리 길이 입력값이 숫자 외의 값이 입력됐습니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String movingInput = Console.readLine();
        movingValidate(movingInput);
        return movingInput;
    }

    public void movingValidate(String movingInput) {
        if(!(movingInput.equals(UP.key()) || movingInput.equals(DOWN.key()))){
            throw new IllegalArgumentException("[ERROR] 입력값이 'U'이나 'D'가 아닙니다.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() throws IllegalArgumentException {
        String gameCommandInput = Console.readLine();
        gameCommandValidate(gameCommandInput);
        return gameCommandInput;
    }

    public void gameCommandValidate(String gameCommandInput) {
        if(!(gameCommandInput.equals(RESTART.key())||gameCommandInput.equals(QUIT.key()))){
            throw new IllegalArgumentException("[ERROR] 입력값이 'R'이나 'Q'가 아닙니다.");
        }
    }
}
