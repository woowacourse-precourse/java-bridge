package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String ERROR_CODE = "[ERROR]";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("\n다리의 길이를 입력해주세요.");
        int length = Integer.parseInt(Console.readLine());
        // TODO: 다리의 길이 체크
        validateBridgeLength(length);

        return length;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        // TODO: input 체크
        validateMovingCommand(input);

        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = Console.readLine();
        // TODO: input 체크
        validateGameCommand(input);

        return input;
    }

    private static void validateBridgeLength(int length) {
        if(length < 3 || length > 20) {
            throw new IllegalArgumentException(ERROR_CODE + " 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private static void validateMovingCommand(String input) {
        if(!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException(ERROR_CODE + " U(위 칸)와 D(아래 칸) 중 하나의 문자만 입력할 수 있습니다.");
        }
    }

    private static void validateGameCommand(String input) {
        if(!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException(ERROR_CODE + " R(재시작)과 Q(종료) 중 하나의 문자만 입력할 수 있습니다.");
        }
    }
}
