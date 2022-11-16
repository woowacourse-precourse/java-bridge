package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String start_input_BridgeSize = "다리 건너기 게임을 시작합니다.\n\n다리의 길이를 입력해주세요.\n";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.printf(start_input_BridgeSize);
        return convertToInt_Validate(Console.readLine());
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

    private int convertToInt_Validate(String input){
        if (!input.matches("^[0-9]*$")){
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(input) < 3 || Integer.parseInt(input) > 20){
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }
}
