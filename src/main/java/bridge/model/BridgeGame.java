package bridge.model;

import bridge.enums.MoveResults;
import bridge.enums.ReverseCommands;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.HashMap;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private JudgeCommand judgeCommand;
    private GameStatus gameStatus;
    private BridgeMaker bridgeMaker;
    private PresentBridgeMaker presentBridgeMaker;

    public BridgeGame(GameStatus gameStatus, BridgeMaker bridgeMaker,
        PresentBridgeMaker presentBridgeMaker) {
        this.gameStatus = gameStatus;
        this.bridgeMaker = bridgeMaker;
        this.presentBridgeMaker = presentBridgeMaker;
    }

    public void initGame() {
        int bridgeSize = InputView.readBridgeSize();
        judgeCommand = new JudgeCommand(gameStatus, bridgeMaker, presentBridgeMaker);
        bridgeMaker.makeBridge(bridgeSize);
        presentBridgeMaker.initPresentBridge();
        gameStatus.initStatus(bridgeSize);
    }

    public void startGame() {
        boolean flag = true;
        while (flag && gameStatus.getBridgeIndex() != gameStatus.getBridgeSize()) {
            String moveCommand = InputView.readMoving();
            flag = move(moveCommand);
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moveCommand) {
        recordBridge(moveCommand, judgeCommand.judgeMove(bridgeMaker.getBridge(), moveCommand,
            gameStatus.getBridgeIndex()));
        OutputView.printMap(presentBridgeMaker.getPresentBridge());
        if (judgeCommand.judgeMove(bridgeMaker.getBridge(), moveCommand,
            gameStatus.getBridgeIndex())) {
            gameStatus.setBridgeIndex(gameStatus.getBridgeIndex() + 1);
            return true;
        }
        gameStatus.setGameResult(false);
        return judgeCommand.judgeContinue();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        presentBridgeMaker.initPresentBridge();
        gameStatus.setBridgeIndex(0);
        gameStatus.setGameResult(true);
        gameStatus.setTryCount(gameStatus.getTryCount() + 1);
    }

    public void recordBridge(String moveCommand, boolean isSuccess) {
        HashMap<String, List<String>> presentBridge = presentBridgeMaker.getPresentBridge();
        String reverseMove = ReverseCommands.getReverseCommand(
            ReverseCommands.valueOf(moveCommand));
        presentBridge = recordLine(presentBridge, moveCommand,
            MoveResults.getResult(MoveResults.valueOf(isSuccess)));
        presentBridge = recordLine(presentBridge, reverseMove, " ");
        presentBridgeMaker.setPresentBridge(presentBridge);
    }

    public HashMap<String, List<String>> recordLine(HashMap<String, List<String>> presentBridge,
        String move, String addValue) {
        List<String> addLine = presentBridge.get(move);
        addLine.add(addValue);
        presentBridge.replace(move, addLine);
        return presentBridge;
    }

    public void endGame() {
        OutputView.printResult(presentBridgeMaker.getPresentBridge(), gameStatus.isGameResult(),
            gameStatus.getTryCount());
    }
}
