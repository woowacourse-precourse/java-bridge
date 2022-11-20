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
    private static final String QUIT_COMMAND_CHARACTER = "Q";

    private OutputView outputView;
    private BridgeNumberGenerator bridgeNumberGenerator;
    private BridgeMaker bridgeMaker;

    public BridgeGame() {
        this.outputView = new OutputView();
        this.bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    public void startGame() {
        try {
            System.out.println(GAME_START_MESSAGE);
            InputController inputController = new InputController();
            int bridgeSize = inputController.getBridgeSize(InputView.readBridgeSize());
            List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
            int gameCount = 0;
            while (true) {
                boolean flag = false;
                boolean success = true;
                gameCount = countGame(gameCount);
                List<String> upperBridge = new ArrayList<>();
                List<String> downBridge = new ArrayList<>();
                for (int i = 0; i < bridge.size(); i++) {
                    String moving = inputController.getMoving(InputView.readMoving());
                    if (move(moving, bridge.get(i))) {
                        outputView.makeMap(moving, MAP_O_CHARACTER, upperBridge, downBridge);
                        outputView.printMap(upperBridge, downBridge);
                    } else if (!move(moving, bridge.get(i))) {
                        success = false;
                        outputView.makeMap(moving, MAP_X_CHARACTER, upperBridge, downBridge);
                        outputView.printMap(upperBridge, downBridge);
                        String gameCommand = inputController.getGameCommand(InputView.readGameCommand());
                        if (retry(gameCommand)) {
                            flag = true;
                        }
                        break;
                    }
                }
                outputView.printResult(upperBridge, downBridge, success, gameCount);
                if (!flag) {
                    break;
                }
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception);
        }

    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving, String bridgeBlock) {
        return moving.equals(bridgeBlock);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        if (gameCommand.equals(RETRY_COMMAND_CHARACTER)) {
            return true;
        } else if (gameCommand.equals(QUIT_COMMAND_CHARACTER)) {
            return false;
        }
        return false;
    }

    public int countGame(int gameCount) {
        gameCount += 1;
        return gameCount;
    }
}
