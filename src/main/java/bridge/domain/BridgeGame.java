package bridge.domain;

현import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.view.OutputView.printRetryMessage;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> bridgGame;
    private int tryCount;

    public BridgeGame(List<String> bridgGame, int tryCount) {
        this.bridgGame = bridgGame;
        this.tryCount = tryCount;
    }
    public boolean matchMoving(int index, String move) {
        return bridgGame.get(index).equals(move);
    }

    public int size() {
        return bridgGame.size();
    }

    public String get(int index) {
        return bridgGame.get(index);
    }

    public String toString(List<String> result) {
        return result.toString();
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    public void retryCount() {
        tryCount ++;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        OutputView.printRetryMessage();
        while (true) {
            String command = InputView.readGameCommand();
            if (command.equals("R")){
                retryCount();
                return true;
            }
            if (command.equals("Q")){
                return false;
            }
            throw new IllegalArgumentException("[ERROR] 'R' 또는 'Q'를 입력해 주세요.");
        }
    }
}
