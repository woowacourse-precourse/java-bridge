package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.model.InputValidator;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String INPUT_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        requestInput(INPUT_BRIDGE_SIZE);
        String input = readLine();
        try {
            InputValidator.isValidSize(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        requestInput(INPUT_MOVING);
        String inputMoving = readLine();
        try {
            InputValidator.isValidMoving(inputMoving);
            return inputMoving;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        requestInput(INPUT_RETRY);
        String inputRetry = readLine();
        try {
            InputValidator.isValidRetry(inputRetry);
            return inputRetry;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

    private static void requestInput(String request) {
        System.out.println(request);
    }
}
