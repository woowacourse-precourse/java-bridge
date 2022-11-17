package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSizeInput = Console.readLine();
        bridgeInputDigitValidate(bridgeSizeInput);
        return Integer.parseInt(bridgeSizeInput);
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
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
