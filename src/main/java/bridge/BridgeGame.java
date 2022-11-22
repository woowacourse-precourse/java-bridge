package bridge;

import message.GameMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private final List<List<String>> bridgeMap;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.bridgeMap = new ArrayList<>();
        init();
    }

    private void init() {
        List<String> initial = List.of("[","]");
        bridgeMap.add(0, initial);
        bridgeMap.add(1, initial);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String movingPosition, int cur) {
        if(check(movingPosition, cur)) {
            makeBridgeMap(movingPosition, cur, true);
            return true;
        }
        makeBridgeMap(movingPosition, cur, false);
        return false;
    }

    private boolean check(String movingPosition, int cur) {
        return bridge.get(cur).equals(movingPosition);
    }

    public void makeBridgeMap(String movingPosition, int cur, boolean success) {
        if(success) {
            correct(movingPosition, cur);
            return;
        }
        wrong(movingPosition, cur);
    }

    private void correct(String movingPosition, int cur) {
        if(movingPosition.equals("U")) {
            correctUp(cur);
            return;
        }
        correctDown(cur);
    }

    private void correctUp(int cur) {
        if(cur % 2 == 1) {
            bridgeMap.get(0).add("|");
            bridgeMap.get(0).add("O");
            return ;
        }
        bridgeMap.get(0).add("O");
    }

    private void correctDown(int cur) {
        if(cur % 2 == 1) {
            bridgeMap.get(1).add("|");
            bridgeMap.get(1).add("O");
            return ;
        }
        bridgeMap.get(1).add("O");
    }

    private void wrong(String movingPosition, int cur) {
        if(movingPosition.equals("U")) {
            wrongUp(cur);
            return;
        }
        wrongDown(cur);
    }

    private void wrongUp(int cur) {
        if(cur % 2 == 1) {
            bridgeMap.get(0).add("|");
            bridgeMap.get(0).add("X");
            return ;
        }
        bridgeMap.get(0).add("X");
    }

    private void wrongDown(int cur) {
        if(cur % 2 == 1) {
            bridgeMap.get(1).add("|");
            bridgeMap.get(1).add("X");
            return ;
        }
        bridgeMap.get(1).add("X");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() { // 틀려서
        System.out.println(GameMessage.Restarting.getMessage());
    }

    public List<List<String>> getBridgeMap() {
        return bridgeMap;
    }
}
