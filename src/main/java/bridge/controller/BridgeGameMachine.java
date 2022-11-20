package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.constants.Command;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeState;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.SystemConsole;
import java.util.List;

public class BridgeGameMachine {

    private final InputView inputView;
    private final OutputView outputView;
    private final SystemConsole systemConsole;

    public BridgeGameMachine(InputView inputView, OutputView outputView,
            SystemConsole systemConsole) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.systemConsole = systemConsole;
    }

    public void run() {
        systemConsole.gameStartMessage();

        systemConsole.bridgeLength();
        int bridgeLength = inputView.readBridgeSize(); // 총길이
        systemConsole.nextLine();

        BridgeRandomNumberGenerator randomGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(randomGenerator);
        List<String> designBridge = bridgeMaker.makeBridge(bridgeLength);// 무작위 [U, D, U]

        BridgeState bridgeState = new BridgeState(systemConsole); // player
        BridgeGame bridgeGame = new BridgeGame(bridgeState);

        String playerRetry = ""; // R Q
        boolean gameSuccess = true;
        int gameCount = 1;

        Loop1:
        while (!(playerRetry.equals(Command.END.getCommand()))) {  // 게임이 성공했을 때?

            bridgeState.initBridgeState();

            for (int bridgeIndex = 0; bridgeIndex < bridgeLength; bridgeIndex++) {

                systemConsole.movementInput();
                String playerMoving = inputView.readMoving();


                String bridgeJudgment = bridgeGame.judgment(playerMoving,
                        designBridge.get(bridgeIndex));

                BridgeState bridgePlace = bridgeGame.move(playerMoving, bridgeJudgment); // 다리 만들기

                bridgePlace = bridgeGame.bridgeConnection(bridgeLength, bridgeJudgment,
                        bridgeIndex);

                outputView.printMap(bridgePlace);
                systemConsole.nextLine();

                if (bridgeJudgment.equals("X")) {

                    systemConsole.gameRestartEnd();
                    String gameCommand = inputView.readGameCommand();

                    playerRetry = bridgeGame.retry(gameCommand);

                    if (playerRetry.equals(Command.RE_START.getCommand())) {
                        gameCount++;
                        break;
                    }

                    if (playerRetry.equals(Command.END.getCommand())) {
                        gameSuccess = false;
                        outputView.printResult(bridgeState, gameCount, gameSuccess);
                        break Loop1;
                    }
                }

                if (bridgeState.findLastValue().contains("]")) {
                    outputView.printResult(bridgeState, gameCount, gameSuccess);
                    playerRetry = "Q";
                    break;
                }
            }
        }
    }
}


