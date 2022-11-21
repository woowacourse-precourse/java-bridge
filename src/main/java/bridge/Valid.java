package bridge;

import camp.nextstep.edu.missionutils.Console;

public class Valid {

    public void validBridgeSize(String value) {
        InputView inputView = new InputView();
        if (!inputView.isBridgeSizeNumber(value)) { // 3 ~ 20이 아니면 true
            throw new IllegalArgumentException();
        }
    }

    public void validReadMoving(String moving) {
        InputView inputView = new InputView();
        if (!inputView.isReadMoving(moving)) { // U 또는 D가 아니라면
            throw new IllegalArgumentException();
        } // end if
    }

    public void validReadGameCommand(String retry) {
        InputView inputView = new InputView();
        if (!inputView.isRetry(retry)) { // R 또는 Q가 아니라면
            throw new IllegalArgumentException();
        } // end if
    }

}
