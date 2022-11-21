package bridge;

import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private Map<String, String> gameResult;
    private int pointer = 0;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    public void runGame() {
        InputView input = new InputView();
        String playerInput = input.readMoving();
        String userMove = move(playerInput);
        OutputView printer = new OutputView();
        printer.printMap(upResultToString(playerInput,userMove),downResultToString(playerInput,userMove));
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
            gameResult.put(playerInput, gameResult.get(playerInput) + move);
            return gameResult.get(playerInput);
        }
        gameResult.put(playerInput, gameResult.get(playerInput) + " ");
        return gameResult.get(playerInput);
    }

    public String downResultToString(String playerInput, String move) {
        if (playerInput.equals("D")) {
            gameResult.put(playerInput, gameResult.get(playerInput) + move);
            return gameResult.get(playerInput);
        }
        gameResult.put(playerInput, gameResult.get(playerInput) + " ");
        return gameResult.get(playerInput);
    }





    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
