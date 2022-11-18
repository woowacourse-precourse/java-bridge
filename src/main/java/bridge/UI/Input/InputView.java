package bridge.UI.Input;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String userInput = Console.readLine();
        validate(userInput, ValidateType.SIZE);
        return Integer.parseInt(userInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String userInput = Console.readLine();
        validate(userInput, ValidateType.MOVE);
        return userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private void validate(String s, ValidateType type){
        if(type == ValidateType.SIZE) checkSize(s);

        if(type == ValidateType.MOVE);

        if(type == ValidateType.COMMAND);
    }

    private void checkSize(String s) {
        try {
            int tempInt = Integer.parseInt(s);

            if(!(tempInt >= 3 && tempInt <= 20)) throw new IllegalArgumentException("[ERROR] 3부터 20 사이의 숫자가 아닙니다.");

        } catch (Exception e) {
            if(e.getClass() == NumberFormatException.class) throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
            if(e.getClass() == IllegalArgumentException.class) throw e;
        }
    }
}
