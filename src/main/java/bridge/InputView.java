package bridge;

import bridge.Setting.BridgeLengthSetting;
import bridge.Setting.BridgeSideIndex;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(String line) throws IllegalArgumentException {
        try {
            int bridgeSize = Integer.parseInt(line);
            validBridgeSize(bridgeSize);
            return bridgeSize;
        } catch (IllegalArgumentException | NoSuchElementException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving(String line) throws IllegalArgumentException {
        try {
            validReadMoving(line);
            return line;
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private void validBridgeSize(int bridgeSize) {
        if (bridgeSize < BridgeLengthSetting.MIN_LENGTH.getLength()
                || bridgeSize > BridgeLengthSetting.MAX_LENGTH.getLength()) {
            throw new NoSuchElementException();
        }
    }

    private void validReadMoving(String line) {
        List<BridgeSideIndex> bridgeSideIndex = List.of(BridgeSideIndex.values());
        for (BridgeSideIndex bridgeSideEach : bridgeSideIndex) {
            if (bridgeSideEach.getLabel().equals(line)) {
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
