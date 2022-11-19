package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.constants.Command;
import bridge.input.InputView;
import bridge.output.OutputView;
import java.util.HashMap;
import java.util.List;

public class BridgeGameMachine {

    public void run() {
        InputView inputView = new InputView();
        int bridgeLength = inputView.readBridgeSize(); // 총길이

        BridgeRandomNumberGenerator randomGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(randomGenerator);
        List<String> designBridge = bridgeMaker.makeBridge(bridgeLength);// 무작위 [U, D, U]

        HashMap<String, StringBuilder> bridgeState = new HashMap<>();

        BridgeGame bridgeGame = new BridgeGame(bridgeState);
        OutputView outputView = new OutputView();

        String playerRetry = "";
        boolean gameSuccess = true;
        int gameCount = 0;

        Loop1:
        while (!(playerRetry.equals(Command.END.getCommand()))) {

            bridgeState.put(Command.UP.getCommand(), new StringBuilder("[ "));
            bridgeState.put(Command.DOWN.getCommand(), new StringBuilder("[ "));

            //TODO: i명칭 수정 하기.
            Loop2:
            for (int bridgeIndex = 0; bridgeIndex < bridgeLength; bridgeIndex++) {
                gameCount++;
                String playerMoving = inputView.readMoving();

                String bridgeJudgment = bridgeGame.judgment(playerMoving,
                        designBridge.get(bridgeIndex)); // U == U -> 'O' 반환

                HashMap<String, StringBuilder> bridgePlace = bridgeGame.move(playerMoving,
                        bridgeJudgment); // 다리 만들기

                HashMap<String, StringBuilder> bridgeConnection = bridgeGame.bridgeConnection(
                        bridgeLength, bridgeJudgment, bridgeIndex);

                outputView.printMap(bridgeConnection);

                if (bridgeJudgment.equals("X")) {

                    System.out.println("게임을 다시 시도할지 여부를 입력해주세요.");
                    String gameCommand = inputView.readGameCommand();

                    playerRetry = bridgeGame.retry(gameCommand);

                    if (playerRetry.equals(Command.RE_START.getCommand())) {
                        break Loop2;
                    }

                    if (playerRetry.equals(Command.END.getCommand())) {
                        gameSuccess = false;
                        outputView.printResult(bridgeState, gameCount, gameSuccess);
                        break;
                    }
                }

                //TODO: 이름수정하기.
                String stringBuilder = String.valueOf(
                        bridgeConnection.get(Command.UP.getCommand()));
                if (stringBuilder.contains("]")) {
                    outputView.printResult(bridgeState, gameCount, gameSuccess);
                    playerRetry = "Q";
                    break;
                }
            }
        }
    }
}


