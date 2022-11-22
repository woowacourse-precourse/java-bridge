package bridge;

import ui.InputView;
import ui.OutputView;
import utils.DrawMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final DrawMap drawMap = new DrawMap();
    private List<String> newBridge;
    private int gameTrialCount = 1;
    private String currentMap;

    /**
     * 다리 건너기 게임을 실행하는 메서드
     */
    public void run() {
        outputView.printGameStart();
        int bridgeSize = inputView.readBridgeSize();

        newBridge = createBridge(bridgeSize);
        List<String> playerInput = new ArrayList<>();

        trial(playerInput);

    }

    /**
     * 한 번 이동할 때마다 실행되는 전체 메서드
     */
    private void trial(List<String> playerInput) {
        for (int i = 0; i < newBridge.size(); i++) {
            playerInput.add(move());
            currentMap = getCurrentMapInString(playerInput);
            outputView.printMap(currentMap);
            int score = calculateScore(playerInput);
            if (score == newBridge.size()) {
                outputView.printResult(currentMap, "성공", gameTrialCount);
                return;
            }
            if (score != playerInput.size()) {
                break;
            }
        }
        retry();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move() {
        outputView.printMove();
        return inputView.readMoving();
    }

    /**
     * 현재 결과를 그림으로 나타내주는 메서드
     */
    public String getCurrentMapInString(List<String> playerInput) {
        return drawMap.returnMapToPrint(newBridge, playerInput);
    }

    /**
     * 사용자가 한 칸 이동한 경우 기록을 업데이트 해주는 메서드
     */
    public List<String> updatePlayerInput(List<String> playerInput, String move) {
        playerInput.add(move);
        return playerInput;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        outputView.printRestart();
        String newCommand = inputView.readGameCommand();
        if (Objects.equals(newCommand, "Q")) {
            outputView.printResult(currentMap,"실패", gameTrialCount);
            return;
        }
        gameTrialCount += 1;
        trial(new ArrayList<>());
    }

    /**
     * 다리 길이를 입력받아 다리를 생성하는 메서드
     */
    public List<String> createBridge(int bridgeSize) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 입력할 때마다 점수를 계산해주는 메서드
     */
    public int calculateScore(List<String> playerInput) {
        int score = 0;
        for (int i = 0; i < playerInput.size(); i++) {
            if (playerInput.get(i).equals(newBridge.get(i))) {
                score += 1;
            }
        }
        return score;
    }

    /**
     * 테스트용으로 사용하는 메서드
     */
    public void setNewBridge(List<String> bridge) {
        newBridge = bridge;
    }
}
