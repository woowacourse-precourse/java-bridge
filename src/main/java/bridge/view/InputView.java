package bridge.view;

import bridge.exception.BridgeGameException;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final BridgeGameException bridgeGameException = new BridgeGameException();

    public String readBridgeSize() {
        try {
            String bridgeSize = Console.readLine();
            checkLengthInput(bridgeSize);
            return bridgeSize;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + "다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            return readBridgeSize();
        }
    }

    private void checkLengthInput(String bridgeSize) {
        bridgeGameException.inputContainCharException(bridgeSize);
        bridgeGameException.checkNumberRangeException(bridgeSize);
    }

    public String readMoving() {
        try {
            String moveInput = Console.readLine();
            checkMoveInput(moveInput);
            return moveInput;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + "위쪽으로 이동하길 원하신다면 U, 아래쪽으로 이동하길 원하신다면 D를 입력해주세요.");
            return readMoving();
        }
    }

    private void checkMoveInput(String moveInput) {
        bridgeGameException.checkCorrectUpOrDownException(moveInput);
        bridgeGameException.checkInputSizeException(moveInput);
    }

    public String readGameCommand() {
        try {
            String retryInput = Console.readLine();
            checkRetryInput(retryInput);
            return retryInput;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + "게임을 재시작하고 싶으시면 R, 그만하고 싶으시면 Q를 입력해주세요.");
            return readGameCommand();
        }
    }

    private void checkRetryInput(String retryInput) {
        bridgeGameException.checkRestartOrDoneException(retryInput);
        bridgeGameException.checkInputSizeException(retryInput);
    }
}
