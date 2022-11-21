package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private static final String MAP_O_CHARACTER = "O";
    private static final String MAP_X_CHARACTER = "X";
    private static final String RETRY_COMMAND_CHARACTER = "R";

    private OutputView outputView;
    private BridgeNumberGenerator bridgeNumberGenerator;
    private BridgeMaker bridgeMaker;

    public BridgeGame() {
        this.outputView = new OutputView();
        this.bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    public void runGame() {
        try {
            startGame();
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void startGame() {
        System.out.println(GAME_START_MESSAGE);
        InputController inputController = new InputController();
        int bridgeSize = inputController.getBridgeSize(InputView.readBridgeSize());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        int gameCount = 0;
        while (true) {
            boolean flag = false;
            boolean success = true;
            gameCount = countGame(gameCount);
            List<List<String>> bridgeMap = new ArrayList<>();
            if (!crossBridge(bridge, inputController, bridgeMap)) {
                success = false;
                String gameCommand = inputController.getGameCommand(InputView.readGameCommand());
                flag = retry(gameCommand);
            }
            outputView.printResult(bridgeMap, success, gameCount);
            if (!flag) {
                break;
            }
        }
    }

    public boolean crossBridge(List<String> bridge, InputController inputController, List<List<String>> bridgeMap) {
        for (String bridgeBlock : bridge) {
            String moving = inputController.getMoving(InputView.readMoving());
            if (!move(moving, bridgeBlock, bridgeMap)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving, String bridgeBlock, List<List<String>> bridgeMap) {
        if (moving.equals(bridgeBlock)) {
            outputView.makeMap(moving, MAP_O_CHARACTER, bridgeMap);
            outputView.printMap(bridgeMap);
            return true;
        }
        outputView.makeMap(moving, MAP_X_CHARACTER, bridgeMap);
        outputView.printMap(bridgeMap);
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        return gameCommand.equals(RETRY_COMMAND_CHARACTER);
    }

    public int countGame(int gameCount) {
        gameCount += 1;
        return gameCount;
    }
}
