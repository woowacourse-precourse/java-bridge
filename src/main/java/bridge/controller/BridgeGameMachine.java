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

    //TODO: (상수화), (enum자리 할당), (메서드 길이제한), (변수명, 메서드명), (get() 가져오는것들 확인)

    public void run() {
        systemConsole.gameStartMessage();

        systemConsole.bridgeLength();
        int bridgeLength = inputView.readBridgeSize();
        systemConsole.nextLine();

        BridgeRandomNumberGenerator randomGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(randomGenerator);
        List<String> designBridge = bridgeMaker.makeBridge(bridgeLength);

        BridgeState bridgeState = new BridgeState(systemConsole);
        BridgeGame bridgeGame = new BridgeGame(bridgeState);

        String playerRetry = "";
        boolean gameSuccess = true;
        int gameCount = 1;

        Loop1:
        while (!(playerRetry.equals(Command.END.getCommand()))) {

            bridgeState.initBridgeState();

            for (int bridgeIndex = 0; bridgeIndex < bridgeLength; bridgeIndex++) {

                systemConsole.movementInput();
                String playerMoving = inputView.readMoving();


                String bridgeJudgment = bridgeGame.judgment(playerMoving,
                        designBridge.get(bridgeIndex));

                BridgeState bridgePlace = bridgeGame.move(playerMoving, bridgeJudgment);

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


