package bridge.view;

import bridge.util.Validater;
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
    private static final String ERROR_MESSAGE_NOT_INT = "[ERROR] 숫자를 입력해주세요.";
    private static final String ERROR_MESSAGE_NOT_PROPER_BRIDGE_SIZE = "[ERROR] 다리 길이는 3이상 20이하의 숫자만 입력 가능합니다.";
    private static final String ERROR_MESSAGE_NOT_PROPER_MOVE = "[ERROR] 대문자 U또는 D를 입력해주세요.";

    private Validater validater = new Validater();

    public int readBridgeSize() {
        String input = Console.readLine();
        System.out.println();
        validater.validateBridgeSize(input);
        int bridgeSize = convertToIntSize(input);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moveCommand = Console.readLine();
        validater.validateMovingInput(moveCommand);
        return moveCommand;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = Console.readLine();
        validater.validateGameCommandInput(gameCommand);
        return gameCommand;
    }

    private int convertToIntSize(String input) {
        return Integer.valueOf(input);
    }
}
