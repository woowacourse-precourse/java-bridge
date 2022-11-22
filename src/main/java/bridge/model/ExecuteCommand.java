package bridge.model;

import bridge.enums.MoveResults;
import bridge.enums.ReverseCommands;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.HashMap;
import java.util.List;

public class ExecuteCommand {

    private JudgeCommand judgeCommand;
    private GameStatus gameStatus;
    private BridgeMaker bridgeMaker;
    private PresentBridgeMaker presentBridgeMaker;

    public ExecuteCommand(GameStatus gameStatus, BridgeMaker bridgeMaker,
        PresentBridgeMaker presentBridgeMaker) {

        this.gameStatus = gameStatus;
        this.bridgeMaker = bridgeMaker;
        this.presentBridgeMaker = presentBridgeMaker;
        this.judgeCommand = new JudgeCommand(this.gameStatus, this.bridgeMaker, this.presentBridgeMaker);
    }

    public void initGame() {
        int bridgeSize = InputView.readBridgeSize();
        gameStatus.setBridgeSize(bridgeSize);
        bridgeMaker.makeBridge(bridgeSize);
        gameStatus.setBridgeIndex(0);
        gameStatus.setGameResult(true);
    }

    public void startGame() {
        initGame();
        boolean flag = true;
        while (flag && gameStatus.getBridgeIndex() != gameStatus.getBridgeSize()) {
            String moveCommand = InputView.readMoving();
            flag = move(moveCommand);
        }
        endGame();
    }

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
