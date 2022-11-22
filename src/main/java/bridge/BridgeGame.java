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
    public boolean move(String movement) {
        if (bridge.get(moveResult.size()).equals(movement)) {
            this.moveResult.add("O");
            return true;
        }
        this.moveResult.add("X");
        return false;
    }
    public boolean retry(String answer) {
        if(answer.equals("R")){
            this.moveResult.clear();
            this.countOfTry++;
            return true;
        }
        return false;
    }
}