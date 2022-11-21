package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int nowLocation;
    private Status status;
    private int challengesCnt;
    private final List<String> bridge;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        challengesCnt = 0;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String userWantedDirection) {
        if (checkingMoving(userWantedDirection)) {
            checkingEnding();
        }
    }

    //끝까지 도달해서 게임이 끝나는 경우
    private void checkingEnding() {
        if (nowLocation == bridge.size()) {
            status = Status.ENDING;
        }
    }

    //다음으로 갈수 있는 경우 true, 없는경우 상태를 바꾸고 false
    private boolean checkingMoving(String userWantedDirection) {
        if (bridge.get(nowLocation++).equals(userWantedDirection)) {
            return true;
        }
        status = Status.FAIL;
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        challengesCnt++;
        nowLocation = 0;
        status = Status.PLAYING;
    }

    public Status getStatus() {
        return status;
    }

    public int getNowLocation() {
        return nowLocation;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getChallengesCnt() {
        return challengesCnt;
    }
}
