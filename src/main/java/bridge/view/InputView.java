package bridge.view;

import static bridge.constant.Constant.ERROR_MESSAGE;

import bridge.exception.Exception;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    Exception bridgeException = new Exception();

    public String readBridgeSize() {
        try {
            String bridgeSize = Console.readLine();
            bridgeException.checkNumberRangeException(bridgeSize);
            return bridgeSize;
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + "다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            return readBridgeSize();
        }
    }

    public String readMoving() {
        try {
            String moveInput = Console.readLine();
            bridgeException.checkCorrectUpOrDownException(moveInput);
            return moveInput;
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + "위쪽으로 이동하길 원하신다면 U, 아래쪽으로 이동하길 원하신다면 D를 입력해주세요.");
            return readMoving();
        }
    }

    public String readGameCommand() {
        try {
            String retryInput = Console.readLine();
            bridgeException.checkRestartOrDoneException(retryInput);
            return retryInput;
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + "게임을 재시작하고 싶으시면 R, 그만하고 싶으시면 Q를 입력해주세요.");
            return readGameCommand();
        }
    }
}