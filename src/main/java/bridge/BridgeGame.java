package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge;
    private int turn;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.turn = 0;
    }

    public void checkMovable(String moving) {
        if (this.bridge.get(turn).equals(moving)) {
            move();
        }
        else {
            retry(InputView.readGameCommand());
        }

    }

    private void checkEnd() {
        if (this.bridge.size() == turn) {
            // 게임 결과 출력 (승리)
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        this.turn++;
        checkEnd();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String gameCommand) {
        if(gameCommand.equals("R")){
            checkMovable(InputView.readMoving());
        }
        else if (gameCommand.equals("Q")){
            // 게임 결과 출력 (패배)
        }
    }
}
