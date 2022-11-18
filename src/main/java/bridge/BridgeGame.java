package bridge;

//InputView와 OutputView 사용 금지

import bridge.UI.Input.InputWhileException;
import bridge.UI.Output.CountRound;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 다리 건너기 게임을 관리하는 클래스
 *
 * 필드를 추가할 수 있다
 */
public class BridgeGame {
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * <p>
     * 메서드의 이름을 변경할 수 없다
     */
    public Map<Integer, Map<String, String>> move(Map<Integer, Map<String, String>> userStatus, List<String> bridge) {
        InputWhileException inputWhileException = new InputWhileException();
        String userInput = inputWhileException.startWhileReadMoving();
        int index = userStatus.size();
        Map<String, String> userResult = new HashMap<>();
        if(userInput.equals(bridge.get(index))) {
            userResult.put(userInput,"O");
        }
            userResult.put(userInput, "X");
            userStatus.put(index, userResult);
        return userStatus;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * 메서드의 이름을 변경할 수 없다
     */
    public void retry(List<String> bridge, CountRound countRound) {
        countRound.count();
        PlayGame playGame = new PlayGame(bridge, countRound);
        playGame.play();

    }

    Condition checkEnd(Map<Integer, Map<String, String>> userStatus, List<String> bridge) {
        Condition condition = Condition.PLAY;
        Set<Map.Entry<String, String>> turnStatus = userStatus.get(userStatus.size()-1).entrySet();
        if(turnStatus.stream().anyMatch(turn -> turn.getValue().equals("X"))) {
            condition = Condition.LOOSE;
        }
        if(bridge.size() == userStatus.size()) {
            condition = Condition.WIN;
        }

        return condition;
    }

}

enum Condition {
    WIN, LOOSE, PLAY
}
