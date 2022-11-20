package bridge.bridgeGame;

import bridge.bridgeGenerator.BridgeRandomNumberGenerator;
import bridge.bridgeMaker.BridgeMaker;
import bridge.inputView.InputView;
import bridge.outputView.OutputView;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String END_COMMAND = "Q";
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGameLog gameLog;
    private final List<String> bridges;

    private boolean isEnd;

    public BridgeGame(InputView inputView, OutputView outputView) {
        OutputView.println("다리 건너기 게임을 시작합니다.");
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameLog = new BridgeGameLog();
        bridges = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(inputView.readBridgeSize());
    }

    public void play() {
        while (!isEnd && !bridges.isEmpty()) {
            move();
            outputView.printMap(gameLog.getBridges());
        }
        outputView.printResult(bridges.isEmpty(), gameLog.getCount());
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void move() {
        String command = inputView.readMoving();
        if (!command.equals(bridges.get(0))) {
            gameLog.addLog(false, command);
            retry();
            return;
        }
        gameLog.addLog(true, command);
        bridges.remove(0);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        String command = inputView.readGameCommand();
        if (command.equals(END_COMMAND)) {
            isEnd = true;
        }
    }
}
