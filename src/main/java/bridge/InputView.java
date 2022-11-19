package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public boolean readBridgeSizeValidation(String input) {
        if(input.matches("(.*)[^0-9](.*)")){
            return false;
        }
        if(Integer.parseInt(input)<3 || Integer.parseInt(input) > 20){
            return false;
        }
        return true;
    }

    public boolean readMovingValidation(String input){
        if(input.equals("U") || input.equals("D")){
            return true;
        }
        return false;
    }

    public boolean readGameCommandValidation(String input){
        if(input.equals("R") || input.equals("Q")){
            return true;
        }
        return false;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        String input = Console.readLine();
        return input;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        return input;
    }
}
