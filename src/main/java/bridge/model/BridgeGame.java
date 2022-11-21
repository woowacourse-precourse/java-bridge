package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.RetryCode;
import bridge.combinator.BridgeCase;

import java.util.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * <p>
 * 요구사항
 * 1. 제공된 BridgeGame 클래스를 활용해 구현해야 한다.
 * 2. BridgeGame 에 필드(인스턴스 변수)를 추가할 수 있다.
 * 3. BridgeGame 의 패키지는 변경할 수 있다.
 * 4. BridgeGame 의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 5. 게임 진행을 위해 필요한 메서드를 추가하거나 변경할 수 있다.
 */
public class BridgeGame {
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final List<String> bridge;
    private int count;

    public BridgeGame(int bridgeSize) {
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
        count = 0;
    }

    public BridgeCase move(String bridgeToMove, int index) {
        if (index == 0) countUp();
        return Arrays.stream(BridgeCase.values())
                .filter(bridgePrinter -> isAnswer(bridgeToMove, index) == bridgePrinter.isAnswer())
                .filter(bridgePrinter -> isFirst(index) == bridgePrinter.isFirst())
                .filter(bridgePrinter -> bridgeToMove.equals(bridgePrinter.getMark()))
                .findFirst()
                .orElse(BridgeCase.DEFAULT);
    }

    public boolean isAnswer(String bridgeToMove, int index) {
        return bridge.get(index).equals(bridgeToMove);
    }

    public boolean retry(String command) {
        return command.equals(RetryCode.RETRY.getRetryCode());
    }

    public boolean isFirst(int index) {
        return index == 0;
    }

    public void countUp() {
        count += 1;
    }

    public int getCount() {   // 수정해보기
        return count;
    }
}
