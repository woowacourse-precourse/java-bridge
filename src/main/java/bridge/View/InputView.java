package bridge.View;

import bridge.domain.Validation;


import static bridge.domain.Validation.validationType;
import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리의 길이를 입력해주세요.");
        String input = getInput(validationType.BRIDGE_SIZE);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return getInput(validationType.MOVING);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return getInput(validationType.GAME_COMMAND);
    }

    private String getInput(Validation.validationType type) {
        String input;
        while (true) {
            try {
                input = readLine();
                Validation.validate(type, input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        return input;
    }
}
