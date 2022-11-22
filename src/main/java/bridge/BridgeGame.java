package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    boolean isSuccess = false;
    int bridgeLength;
    int trialCount = 0;
    List<String> bridgeRoute;
    List<String> myRoute = new ArrayList<>();
    int step = 0;
    int howFar=0;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String uD, int loopIndex) {
        myRoute = setMyRoute(loopIndex, uD);
        if (!bridgeRoute.get(step).equals(uD)) {
            wrongAnswer();
            return false;
        }
        rightAnswer();
        return true;
    }

    public void wrongAnswer() {
        step++;
        howFar=step;
        step = 0;
    }
    public void rightAnswer() {
        step++;
        howFar=step;
    }

    public List<String> setMyRoute(int index, String uD) {
        if (index == 0) {
            myRoute = new ArrayList<>();
        }
        myRoute.add(uD);
        return myRoute;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String restartOrQuit) {
        if (restartOrQuit.equals("Q")) {
            return true;
        }
        return false;
    }
}
