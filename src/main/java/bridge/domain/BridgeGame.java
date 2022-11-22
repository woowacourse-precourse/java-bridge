package bridge.domain;

import bridge.domain.enums.GameCommand;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public boolean keepPlayingIndex = true;
    public int count = 1;
    public int bridgeIndex = 0;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String userMove, String answer) {
        if (!answer.equals(userMove)) {
            keepPlayingIndex = false;
            return false;
        }
        bridgeIndex++;
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public boolean retry(String command) {
        if (command.equals(GameCommand.RETRY.getValue())) {
            keepPlayingIndex = true;
            count++;
            bridgeIndex = 0;
            return true;
        }
        return false;
    }
}