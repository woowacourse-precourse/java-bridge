package bridge.game;

import bridge.bridge.Bridge;
import bridge.config.BridgeStatus;
import bridge.config.GameResultStatus;
import bridge.view.InputView;

import java.util.List;

import static bridge.config.GameResultStatus.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    InputView inputView = new InputView();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameResultStatus move(Bridge bridge) {

        String result = inputView.readMoving();
        BridgeStatus status = bridge.getBridge().get(bridge.getPosition());

        if (status.getPosition().equals(result)) {
            bridge.getGameResultStatuses().add(O);
        }

        bridge.movePosition();
        return bridge.getGameResultStatuses().get(bridge.getPosition() - 1);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(Game game) {
        game.addCount();

    }

}
