package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private InputView inputView;
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private OutputView outputView;

    private List<String> playerCommands;
    private int plyerMoveCount = 0;

    private GameMap gameMap = new GameMap();

    private List<String> bridge; // 직접 접근을 막고 bridge to map 으로 반환하여 출력하게끔
    public BridgeGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
    public void play() {
        System.out.println(START_MESSAGE);
        int bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
        playerCommands = new ArrayList<>();
        String playerCommand = inputView.readMoving();
        move(playerCommand);
        outputView.printMap(gameMap);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveCommand) {
        playerCommands.add(moveCommand);
        plyerMoveCount++;
        gameMap.add(moveCommand, checkMoveResult(moveCommand));
    }

    private String checkMoveResult(String moveCommand) {
        String result = "";
        if (moveCommand.equals(bridge.get(plyerMoveCount))) {
            result = "O";
        }

        if (!moveCommand.equals(bridge.get(plyerMoveCount))) {
            result = "X";
        }
        return result;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
