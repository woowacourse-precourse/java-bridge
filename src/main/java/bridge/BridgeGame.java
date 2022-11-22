package bridge;

import bridge.enums.BlockExpression;
import bridge.enums.GameOver;
import bridge.enums.GameResult;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(List<String> userInput, String moving) {
        userInput.add(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(List<String> userInput) {
        userInput.clear();
    }

    public boolean verifyGameSuccess(List<String> matchingResult, GameResult gameResult) {
        int lastIndex = matchingResult.size()-1;

        if(matchingResult.get(lastIndex).equals(BlockExpression.Diff.getMark())) {
            gameResult = GameResult.FAILED;
            return true;
        }

        return false;
    }

    public GameOver verifyGameOver(List<String> bridge, List<String> userInput) {
        if(bridge.size() == userInput.size()) {
            return GameOver.OVER;
        }

        return GameOver.YET;
    }
}
