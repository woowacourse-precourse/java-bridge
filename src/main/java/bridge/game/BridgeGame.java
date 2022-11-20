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
    private int countOfTry = 1;

    public BridgeGame(int length) {
        bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(length);
        route = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String road) {
        route.add(road);
    }

    public BridgeGameDto getBridgeGameDto() {
        return new BridgeGameDto(bridge, route, countOfTry);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        route.clear();
        countOfTry++;
    }

    public boolean isContinue() {
        if (route.size() == 0) {
            return true;
        }
        if (route.size() >= bridge.size()) {
            return false;
        }

        return IntStream.range(0, route.size())
                .mapToObj(index -> isCorrectRoute(index))
                .reduce(true, Boolean::logicalAnd);
    }

    private boolean isCorrectRoute(int index) {
        return route.get(index).equals(bridge.get(index));
    }

    public boolean isSuccess() {
        return route.equals(bridge);
    }
}
