package bridge.inputView;

import bridge.common.ErrorMessage;
import bridge.inputView.exception.IllegalReadBridgeSizeException;
import bridge.inputView.exception.IllegalReadGameCommandException;
import bridge.inputView.exception.IllegalReadMovingException;
import bridge.outputView.OutputView;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            OutputView.println("다리의 길이를 입력해주세요.");
            return InputEngine.readBridgeSize();
        } catch (NumberFormatException | IllegalReadBridgeSizeException e) {
            OutputView.println(ErrorMessage.ILLEGAL_READ_BRIDGE_SIZE.getTagMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            OutputView.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            return InputEngine.readMoving();
        } catch (IllegalReadMovingException e) {
            OutputView.println(e.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            OutputView.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            return InputEngine.readGameCommand();
        } catch (IllegalReadGameCommandException e) {
            OutputView.println(e.getMessage());
            return readGameCommand();
        }
    }
}
