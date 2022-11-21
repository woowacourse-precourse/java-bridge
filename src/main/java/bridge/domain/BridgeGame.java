package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static BridgeGame instance; // BridgeGame 클래스의 인스턴스
    private List<String> bridgeStatus; // 다리의 상태
    private final List<String> movingStatus; // 사용자 이동상태
    private int attemptsCount; // 시도한 횟수

    private BridgeGame() { // for singleton pattern
        this.movingStatus = new ArrayList<>();
        this.attemptsCount = 1;
    }

    public static BridgeGame getInstance() {
        if (instance == null) {
            instance = new BridgeGame();
        }
        return instance;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String command) {
        movingStatus.add(command);
        return isMovable(command, bridgeStatus);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        attemptsCount++;
        movingStatus.clear();
    }

    public void setBridgeStatus(List<String> bridgeStatus) {
        this.bridgeStatus = bridgeStatus;
    }

    public List<String> getMovingStatus() {
        return this.movingStatus;
    }

    public int getAttemptsCount() {
        return this.attemptsCount;
    }

    /*
     * 게임을 성공했는 지에 대한 여부를 확인함
     */
    public boolean isGameSuccess() {
        if (bridgeStatus.size() != movingStatus.size()) {
            return false;
        }
        for (int i = 0; i < bridgeStatus.size(); i++) {
            if (!bridgeStatus.get(i).equals(movingStatus.get(i))) {
                return false;
            }
        }
        return true;
    }

    /*
     * 현재의 이동 명령이 수행 가능한 명령인 지 확인하는 기능
     * 이동이 가능한 경우 true, 불가한 경우 false를 반환함
     */
    private boolean isMovable(String command, List<String> bridge) {
        return command.equals(bridge.get(movingStatus.size() - 1));
    }
}
