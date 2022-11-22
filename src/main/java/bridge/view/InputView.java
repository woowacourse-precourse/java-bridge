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
}