package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private List<String> player = new ArrayList<>();
    private String upResult = "";
    private String downResult = "";
    private int retryCount = 1;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean runGame() {
        InputView input = new InputView();
        OutputView printer = new OutputView();
        while (bridge.size() != player.size()) {
            String playerMove = input.readMoving();
            if (!move(playerMove)) {
                resultToString(playerMove,"X");
                printer.printMap(upResult,downResult);
                player.clear();
                if (retry(input.readGameCommand())) {
                    upResult = "";
                    downResult = "";
                    retryCount++;
                    continue;
                }
                printer.printResult(upResult,downResult);
                return false;
            }
            resultToString(playerMove,"O");
            printer.printMap(upResult,downResult);
        }
        printer.printResult(upResult,downResult);
        return true;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String playerInput) {
        player.add(playerInput);
        return bridge.get(player.size() - 1).equals(playerInput);
    }

    public void resultToString(String playerInput, String result){
        if (playerInput.equals("U")) {
            upResult += result;
            downResult += " ";
        }
        if (playerInput.equals("D")) {
            upResult += " ";
            downResult += result;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String userInput) {
        return userInput.equals("R");
    }

    public int getRetryCount(){
        return retryCount;
    }
}
