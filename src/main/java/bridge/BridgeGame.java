package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public final List<String> bridge;
    public final List<String> moveResult = new ArrayList<>();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        public int countOfTry = 1;
        BridgeGame(List<String> bridge) {
            this.bridge = bridge;
        }

        /**
         * 사용자가 게임을 다시 시도할 때 사용하는 메서드
         * <p>
         * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
         */
        public void retry() {
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
    }