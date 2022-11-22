package bridge.view;

import static bridge.constant.Constant.ERROR_MESSAGE;

import bridge.exception.BridgeException;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    BridgeException bridgeException = new BridgeException();
    public String readBridgeSize() {
        try {
            String bridgeSize = Console.readLine();
            checkLengthInput(bridgeSize);
            return bridgeSize;
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + "다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            return readBridgeSize();
        }
    }
    public void checkLengthInput(String bridgeSize) {
        bridgeException.inputContainsCharException(bridgeSize);
        bridgeException.checkNumberRangeException(bridgeSize);
    }
    public String readMoving() {
        try {
            String moveInput = Console.readLine();
            checkMoveInput(moveInput);
            return moveInput;
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + "위쪽으로 이동하길 원하신다면 U, 아래쪽으로 이동하길 원하신다면 D를 입력해주세요.");
            return readMoving();
        }
    }
    public void checkMoveInput(String moveInput) {
        bridgeException.checkCorrectUpOrDownException(moveInput);
        bridgeException.checkInputSizeException(moveInput);
    }
    public String readGameCommand() {
        try {
            String retryInput = Console.readLine();
            checkRetryInput(retryInput);
            return retryInput;
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + "게임을 재시작하고 싶으시면 R, 그만하고 싶으시면 Q를 입력해주세요.");
            return readGameCommand();
        }
    }
    public void checkRetryInput(String retryInput) {
        bridgeException.checkRestartOrDoneException(retryInput);
        bridgeException.checkInputSizeException(retryInput);
    }
}
