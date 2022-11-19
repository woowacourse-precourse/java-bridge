package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String errorMsg = "ERROR";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input;
        do {
            input = Console.readLine();
        } while (bridgeSizeStringToInt(input) == -1);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input;
        do {
            input = Console.readLine();
        } while (!checkMoving(input));
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    public int bridgeSizeStringToInt(String input){
        try {
            int bridgeSize = Integer.parseInt(input);
            if (bridgeSize < 3 || bridgeSize > 20) {
                throw new IllegalArgumentException();
            }
            return bridgeSize;
        } catch (IllegalArgumentException e) {
            System.out.println(errorMsg);
            return -1;
        }
    }

    public boolean checkMoving(String input){
        try{
            if(!input.equals("U") || !input.equals("D")){
                throw new IllegalArgumentException();
            }
            return true;
        } catch (IllegalArgumentException e){
            System.out.println(errorMsg);
            return false;
        }
    }
}
