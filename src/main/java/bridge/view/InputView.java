package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 *
 * 요구 사항 분석 :
 * InputView 클래스에서만 camp.nextstep.edu.missionutils.Console 의 readLine() 메서드를 이용해 사용자의 입력을 받을 수 있다.
 *
 * 제공된 InputView 클래스를 활용해 구현해야 한다.
 * InputView의 패키지는 변경할 수 있다.
 * InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 * 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class InputView {
    private static final String INPUT_MESSAGE_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MESSAGE_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String ERROR_MESSAGE_NOT_INT = "[ERROR] 숫자를 입력해주세요.";
    private static final String ERROR_MESSAGE_NOT_PROPER_MOVE = "[ERROR] 대문자 U또는 D를 입력해주세요.";



    public int readBridgeSize() {
        printInputMessageBridgeSize();
        int bridgeSize = inputBridgeSize();
        return bridgeSize;
    }

    private int inputBridgeSize() {
        int bridgeSize;
        while (true) {
            String size = Console.readLine();
            try {
                bridgeSize = Integer.valueOf(size);
                break;
            } catch (NumberFormatException e) {
                System.out.println(ERROR_MESSAGE_NOT_INT);
                continue;
            }
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        printInputMessageMoving();
        String input = Console.readLine();
        validateMovingInput(input);
        return input;
    }

    private void printInputMessageBridgeSize() {
        System.out.println(INPUT_MESSAGE_BRIDGE_SIZE);
    }

    private void printInputMessageMoving() {
        System.out.println(INPUT_MESSAGE_MOVING);
    }

    private void validateMovingInput(String input) {
        if (!(input.equals("D") || input.equals("U"))) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_PROPER_MOVE);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
