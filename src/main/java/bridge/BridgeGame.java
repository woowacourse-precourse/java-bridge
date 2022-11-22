package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public final List<String> bridge;
    public final List<String> moveResult = new ArrayList<>();

    public int countOfTry = 1;
    BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * @param movement 이동할 위치
     * @return 이동 성공 여부
     */
    public boolean move(String movement) {
        if (bridge.get(moveResult.size()).equals(movement)) {
            this.moveResult.add("O");
            return true;
        }
        this.moveResult.add("X");
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * @param answer 입력한 커맨드
     * @return 재시도 여부
     */
    public boolean retry(String answer) {
        if(answer.equals("R")){
            this.moveResult.clear();
            this.countOfTry++;
            return true;
        }
        return false;
    }
}
