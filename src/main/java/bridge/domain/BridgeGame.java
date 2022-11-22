package bridge.domain;

import static bridge.common.message.ConsoleOut.GAME_NUMBER_OF_ATTEMPTS;

import bridge.common.message.ConsoleOut;
import bridge.domain.vo.MatchResult;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Integer gameTimes = 1;
    private List<String> userInputs;

    public BridgeGame() {
        userInputs = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(List<String> givenBridge, String userInput, int index) {
        userInputs.add(userInput);
        // userInput과 bridge의 결과가 맞다면
        if (givenBridge.get(index).equals(userInputs.get(index))) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(MatchResult matchResult) {
        matchResult.reset();
        gameTimes += 1;
    }

    public List<String> currentUserInput() {
        return userInputs;
    }

    public void currentGameTime() {
        System.out.println(GAME_NUMBER_OF_ATTEMPTS.currentMessage() + String.valueOf(gameTimes));
    }

    public void looseGame() {
        ConsoleOut.LOOSING_GAME_MESSAGE.print();
        currentGameTime();
    }
    public void winningGame() {
        ConsoleOut.WINNING_GAME_MESSAGE.print();
        currentGameTime();
    }
}
