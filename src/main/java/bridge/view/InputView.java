package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readUserInput() {
        return readLine();
    }

    public int readBridgeSize(String input) {
        validBridgeSize(input);
        return Integer.parseInt(input);
    }

    void validBridgeSize(String input) throws IllegalArgumentException {
        if (!isNumber(input)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 '숫자'여야 합니다.");
        }
        if (!isNumberInValidRange(input)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");

        }
    }

    private boolean isNumberInValidRange(String input) {
        int number = Integer.parseInt(input);
        return number <= 20 && number >= 3;
    }

    private boolean isNumber(String input) {
        for (int i = 0; i <input.length() ; i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving(String input) {
        validMoving(input);
        return input;
    }

    private void validMoving(String input) throws IllegalArgumentException {
        if (!isWrongMoving(input)) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U(위), D(아래)만 선택 가능합니다.");
        }
    }


    private boolean isWrongMoving(String input) {
            return input.equals("U") || input.equals("D");

    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand(String input) {
        validCommand(input);
        return input;
    }

    private void validCommand(String input) throws IllegalArgumentException {
        if (!isValidCommandInput(input)) {
            throw new IllegalArgumentException("[ERROR] 다시 시도 여부는 R(재시도), Q(종료)만 선택 가능합니다.");
        }
    }

    private boolean isValidCommandInput(String input) {
        return input.equals("R") || input.equals("Q");
    }
}
