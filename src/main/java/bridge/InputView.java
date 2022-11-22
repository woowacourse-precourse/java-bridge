package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
       String input = Console.readLine();
       validateBridgeSizeNumFormat(input);
       int bridgeSize = Integer.parseInt(input);
       validateBridgeSizeRange(bridgeSize);
        return bridgeSize;
    }
    private void validateBridgeSizeRange(int bridgeSize){
        if(21<bridgeSize && bridgeSize<3)
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3~20사이의 수입니다.");
    }
    private void validateBridgeSizeNumFormat(String input){
        try {
            int bridgeSize = Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자의 형식만 입력 가능합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
