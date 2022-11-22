package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final CurrentLocationInformation currentLocationInformation = new CurrentLocationInformation();
    // InputView, OutputView 사용 금지!!@@@@

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(List<String> bridge, String moving, int count) {
        currentLocationInformation.showMyLocation(bridge, moving, count);
        return (bridge.get(count).equals(moving));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String restartAndQuit) {
        if (restartAndQuit.equals("Q")) {
            return false;
        }
        if (restartAndQuit.equals("R")) {
            CurrentLocationInformation.init();
            return true;
        }
        return false;
    }
}
