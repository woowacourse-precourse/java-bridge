package bridge.view;

import bridge.utils.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static InputView inputview = new InputView();

    private InputView() {
    }

    public static InputView getInputView() {
        if (inputview == null) {
            inputview = new InputView();
        }
        return inputview;
    }

    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요. ");
        String bridgeSize = Console.readLine();
        InputValidator.validateBridgeSizeInput(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String playerMoving = Console.readLine();
        InputValidator.validatePlayerMovingInput(playerMoving);
        return playerMoving;
    }

    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand = Console.readLine();
        InputValidator.validateGameCommandInput(gameCommand);
        return gameCommand;
    }
}
