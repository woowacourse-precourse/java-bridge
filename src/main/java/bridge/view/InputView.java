package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    private String getInput(String prompt) {
        System.out.println(prompt);
        return readLine();
    }

    public int readBridgeSize() {
        int size = 0;
        try {
            size = Integer.parseInt(getInput("\n다리의 길이를 입력해주세요."));
            if (size < 3 || size > 20) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            generateError("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return size;
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
    public void generateError(String message) {
        throw new IllegalArgumentException(message);
    }
}
