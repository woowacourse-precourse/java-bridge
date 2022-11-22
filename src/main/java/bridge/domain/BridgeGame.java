package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int nowLocation; //현재까지 이동한 위치
    private Status status; //게임의 현재 상황
    private int challengesCnt; //도전 횟수
    private final List<String> bridge;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        challengesCnt = 1;
        initialization();
    }

    public void move(String userWantedDirection) {
        if (checkingMoving(userWantedDirection)) {
            checkingEnding();
        }
        nowLocation++;
    }

    //다음칸으로 이동이 가능한지 확인한다.(이동이 불가능 하다면 게임상황을 FAIL 로 변경한다)
    private boolean checkingMoving(String userWantedDirection) {
        if (bridge.get(nowLocation).equals(userWantedDirection)) {
            return true;
        }
        status = Status.FAIL;
        return false;
    }

    //방금 이동한 칸이 마지막 칸인경우 게임의 상태를 종료로 변경한다.
    private void checkingEnding() {
        if (nowLocation == bridge.size() - 1) {
            status = Status.ENDING;
        }
    }

    public void retry() {
        challengesCnt++;
        initialization();
    }

    private void initialization() {
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
