package bridge.view;

import bridge.utils.Validation;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readBridgeSize() {
        try {
            System.out.println("다리의 길이를 입력해주세요.");
            String bridgeSize = Console.readLine();
            return Validation.validateBridgeSize(bridgeSize);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return readBridgeSize();
        }
    }

    public String readMoving() {
        try {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String moving = Console.readLine();
            return Validation.validateMoving(moving);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return readMoving();
        }
    }

    public String readGameCommand() {
        try {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String restartAnswer = Console.readLine();
            return Validation.validateRestartInput(restartAnswer);
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return readGameCommand();
        }
    }
}
