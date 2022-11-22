package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.dto.MovingResultDto;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker;

    private int position;
    private int tryCount;
    private List<String> bridge;
    private List<String> result;

    /**
     * 다리 생성기를 주입하고, 시도 횟수를 초기화하는 메서드
     */
    public BridgeGame(BridgeNumberGenerator bridgeNumberGenerator) {
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        tryCount = 0;
    }

    /**
     * 게임 시작 전, 다리를 세팅하는 메서드
     */
    public void settingBridge(int bridgeSize) {
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 게임을 시작하는 메서드
     */
    public void initGame() {
        result = new ArrayList<>();
        position = 0;
        tryCount += 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public MovingResultDto move(String commend) {
        String correctPosition = bridge.get(position);
        result.add(commend);

        if (correctPosition.equals(commend)) {
            position += 1;
            return new MovingResultDto(result, position, false);
        }

        return new MovingResultDto(result, position, true);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     * @return 다시 시작 여부
     */
    public boolean retry(String input) {
        if (input.equals("R")) {
            initGame();
            return true;
        }

        return false;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getTryCount() {
        return tryCount;
    }
}
