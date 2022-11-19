package bridge.game;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.dto.BridgeGameDto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private List<String> route;

    BridgeGame(int length) {
        bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(length);
        route = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeGameDto move(String road) {
        route.add(road);
        return new BridgeGameDto(bridge, route);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        route.clear();
    }

    public boolean isContinue() {
        if (route.size() == 0) {
            return true;
        }

        return IntStream.range(0, route.size())
                .mapToObj(index -> isCorrectRoute(index))
                .reduce(true, Boolean::logicalAnd);
    }

    private boolean isCorrectRoute(int index) {
        return route.get(index).equals(bridge.get(index));
    }
}
