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
        // 총길이
        int bridgeLength = inputView.readBridgeSize();

        BridgeRandomNumberGenerator randomGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(randomGenerator);
        // [U, D, U]
        List<String> designBridge = bridgeMaker.makeBridge(bridgeLength);

        HashMap<String, StringBuilder> bridgeState = new HashMap<>();

        bridgeState.put(Command.UP.getCommand(), new StringBuilder("[ "));
        bridgeState.put(Command.DOWN.getCommand(), new StringBuilder("[ "));

        PlayerAndRandom playerAndRandom = new PlayerAndRandom();
        BridgeGame bridgeGame = new BridgeGame(bridgeState);

        for (int i = 0; i < bridgeLength; i++) {
            String playerMoving = inputView.readMoving();

            String bridgeJudgment = playerAndRandom.Judgment(playerMoving, designBridge.get(i));

            HashMap<String, StringBuilder> bridgePlace = bridgeGame.move(playerMoving, bridgeJudgment);

            bridgeConnection(bridgeLength, bridgeState, i);

            //TODO: 게임을 다시 시도할지 여부를 입력해주세요. -> 구현해야됨.
        }
    }





    private void bridgeConnection(int bridgeLength, HashMap<String, StringBuilder> bridgeState, int i) {
        if (i != bridgeLength -1) {
            bridgeState.get(0).append(" |");
            bridgeState.get(1).append(" |");
        }

        if (i == bridgeLength -1) {
            bridgeState.get(0).append(" ]");
            bridgeState.get(1).append(" ]");
        }
    }
}


