package bridge.view;

import bridge.service.dto.request.BridgeSizeRequestDto;
import bridge.service.dto.request.SelectBlockRequestDto;
import bridge.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVING_SPACE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public BridgeSizeRequestDto readBridgeSize() {
        while (true) {
            try {
                System.out.println(INPUT_BRIDGE_SIZE);
                return new BridgeSizeRequestDto(InputValidator.checkBridgeSize(Console.readLine()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public SelectBlockRequestDto readMoving() {
        while (true) {
            try {
                System.out.println(INPUT_MOVING_SPACE);
                return new SelectBlockRequestDto(InputValidator.checkMovingSpace(Console.readLine()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
