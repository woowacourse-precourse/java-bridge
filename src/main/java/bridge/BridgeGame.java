package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */

public class BridgeGame {
    private final List<String> bridge = new ArrayList<>();
    private final List<String> upBridge  = new ArrayList<>(); //
    private final List<String> downBridge = new ArrayList<>();
    private final List<String> moveUser = new ArrayList<>();
    private final List<String> restart = new ArrayList<>();
    private int cnt = 1; // 게임 횟수
    private int bridge_create = 0;


    private final int bridge_len;
    public BridgeGame(int bridge_len) {
        this.bridge_len = bridge_len;

    }
//    public BridgeGame(int bridgesize_len) {
//
//    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void move(String userInput) {
        if (userInput.equals(Choose.UP.getValue())) {
            moveUser.add(Choose.UP.getValue());
        }
        if (userInput.equals(Choose.DOWN.getValue())) {
            moveUser.add(Choose.DOWN.getValue());
        }
        cnt++;
        makeBridge();
//        return false;
    }

    public boolean rightAnswer() {
        int idx = bridge_create -1;
        if(moveUser.get(idx) == bridge.get(idx)) {
            return true;
        }
        return false;
    }

    public void makeBridge() {
        String result = Choose.FAILURE.getValue();
        if (rightAnswer()) {
            result = Choose.SUCCESS.getValue();
        }
        makeupBridge(result);
        makedownBridge(result);
    }

    private void makeupBridge(String result) {
        if(moveUser.get(moveUser.size()-1) == Choose.UP.getValue()) {
            upBridge.add(result);
            return;
        }
        upBridge.add(" ");
    }

    private void makedownBridge(String result) {
        if(moveUser.get(moveUser.size()-1) == Choose.DOWN.getValue()) {
            downBridge.add(result);
            return;
        }
        downBridge.add(" ");
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @return
     */
    public boolean theEnd() {
        if(bridge_create == 0)
            return false;
        if (rightAnswer() && bridge_create == bridge.size()) {
            return true;
        }
        return false;
    }

    public String gameResult() {
        if(theEnd()) {
            return "게임 성공";
        }
        return "게임 실패";
    }


    public boolean retry() {
        new InputView().readGameCommand();
        moveUser.clear();
        upBridge.clear();
        downBridge.clear();

        if(InputView.gameRestart.equals(Choose.RESTART.getValue())) {
            restart.add(Choose.RESTART.getValue());
            cnt++;
        }
        if(InputView.gameRestart.equals(Choose.EXIT.getValue())) {
            restart.add(Choose.EXIT.getValue());
            cnt++;
        }
        return false;
    }

    public List<String> getUpBridge() {
        return getUpBridge();
    }
    public List<String> getDownBridge() {
        return getDownBridge();
    }
    public int gameCnt() {
        return cnt;
    }


}