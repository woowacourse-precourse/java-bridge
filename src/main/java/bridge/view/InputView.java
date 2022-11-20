package bridge.view;

import bridge.Check;
import camp.nextstep.edu.missionutils.Console;

import static bridge.Utility.convertStringToInt;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public String readInput(){
        String input = Console.readLine();
        return input;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input;
        boolean check1, check2;
        while(true) {
            input = readInput();
            check2 = false;
            check1 = Check.checkNumeric(input);
            if(check1) {
                check2 = Check.checkBridgeLengthOutOfRange(Integer.parseInt(input));
            }
            if (check1 && check2) break;
        }
        int bridgeSize = convertStringToInt(input);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input;
        boolean check;
        while(true){
            input = readInput();
            check = Check.checkMoveValid(input);
            if(check) break;
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
