package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private int pointer = 0;
    private String upResult = "";
    private String downResult = "";

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    public void runGame() {
        InputView input = new InputView();
        String playerInput = input.readMoving();
        String userMove = move(playerInput);
        OutputView printer = new OutputView();
        printer.printMap(upResultToString(playerInput, userMove), downResultToString(playerInput, userMove));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String playerInput) {
        if (bridge.get(pointer).equals(playerInput)) {
            pointer++;
            return "O";
        }
        return "X";
    }

    public String upResultToString(String playerInput, String move) {
        if (playerInput.equals("U")) {
            upResult += move;
            return upResult;
        }
        upResult += " ";
        return upResult;
    }

    public String downResultToString(String playerInput, String move) {
        if (playerInput.equals("D")) {
            downResult += move;
            return downResult;
        }
        downResult += " ";
        return downResult;
    }

    public boolean isSuccess(String move) {
        return !move.equals("X");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
