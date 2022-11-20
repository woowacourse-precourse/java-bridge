package bridge.game;

import bridge.BridgeMaker;
import bridge.domain.Bridge;
import bridge.domain.Retry;
import bridge.domain.User;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    BridgeMaker bridgeMaker;

    public BridgeGame(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Bridge bridge, Supplier<String> readFunction, BiConsumer<Integer, String> writeFunction) {
        int index = 0;
        String way;

        do {
            way = readFunction.get();
            writeFunction.accept(index,way);
        } while (bridge.canGo(index++, way) && index < bridge.getSize());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(Bridge bridge, User user, Supplier<String> readFunction) {
        user.setGameCleared(bridge.getSize() == user.getPosition() && user.canGoAllBridges());

        if (!user.getGameCleared()) {
            return Retry.getValue(readFunction.get());
        }
        return false;
    }

    public Bridge construct(Supplier<Integer> readFunction){
        int bridgeSize = readFunction.get();

        return new Bridge(bridgeMaker.makeBridge(bridgeSize), bridgeSize);
    }
}
