package bridge.controller;

import bridge.domain.BridgeRandomNumberGenerator;
import bridge.constants.Command;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeState;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameMachine {
    private static final int GAME_INITIAL_VALUE = 1;
    private static final int START_BRIDGE = 0;
    private static final String FAILURE = "X";
    private static final String EMPTY_VALUE = "";

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameMachine(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    //TODO: 메서드 길이제한, (get() 가져오는것들 확인)

    public void run() {
        systemConsole.gameStartMessage();

        systemConsole.bridgeLength();
        int bridgeLength = inputView.readBridgeSize();
        systemConsole.nextLine();

        BridgeRandomNumberGenerator randomGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(randomGenerator);
        List<String> designBridge = bridgeMaker.makeBridge(bridgeLength);

        BridgeState bridgeState = new BridgeState();
        BridgeGame bridgeGame = new BridgeGame(bridgeState);

        String playerRetry = EMPTY_VALUE;
        boolean gameSuccess = true;
        int gameCount = GAME_INITIAL_VALUE;

        Loop1:
        while (!(playerRetry.equals(Command.END.getCommand()))) {

            for (int bridgeIndex = START_BRIDGE; bridgeIndex < bridgeLength; bridgeIndex++) {

                outputView.printMovementInput();
                String playerMoving = inputView.readMoving();

                String bridgeJudgment = bridgeGame.judgment(playerMoving,
                        designBridge.get(bridgeIndex));

                BridgeState bridgePlace = bridgeGame.move(playerMoving, bridgeJudgment);

                outputView.printMap(bridgePlace);
                outputView.printNextLine();

                if (bridgeJudgment.equals(FAILURE)) {

                    systemConsole.gameRestartEnd();
                    String gameCommand = inputView.readGameCommand();

                    playerRetry = bridgeGame.retry(gameCommand);

                    if (playerRetry.equals(Command.RE_START.relevantCommand())) {
                        gameCount++;
                        break;
                    }

                    if (playerRetry.equals(Command.END.relevantCommand())) {
                        gameSuccess = false;
                        outputView.printResult(bridgeState, gameCount, gameSuccess);
                        break Loop1;
                    }
                }

                if (bridgeIndex == bridgeLength - 1) { // TODO: 상수화
                    outputView.printResult(bridgeState, gameCount, gameSuccess);
                    playerRetry = Command.END.relevantCommand();
                    break;
                }
            }
        }
    }
}


