package bridge.View;

import bridge.Instances.InputValidationType;
import bridge.domain.Validation;


import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    static final String START_GAME = "다리 건너기 게임을 시작합니다.";
    static final String ENTER_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    static final String ENTER_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    static final String ENTER_GAME_COMMAND="게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public int readBridgeSize() {
        System.out.println(START_GAME);
        System.out.println(ENTER_BRIDGE_SIZE);
        String input = readInput(InputValidationType.BRIDGE_SIZE);
        return Integer.parseInt(input);
    }

    public String readMoving() {
        System.out.println(ENTER_MOVING);
        return readInput(InputValidationType.MOVING);
    }

    public String readGameCommand() {
        System.out.println(ENTER_GAME_COMMAND);
        return readInput(InputValidationType.GAME_COMMAND);
    }

    private String readInput(InputValidationType type) {
        String input;
        while (true) {
            try {
                input = readAndValidateInput(type);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            return input;
        }
    }

    private String readAndValidateInput(InputValidationType type) {
        String input = readLine();
        Validation.validateInput(type, input);
        return input;
    }
}
