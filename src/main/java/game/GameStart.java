package game;

import bridge.BridgeGame;
import bridge.InputView;
import bridge.OutputView;

import java.util.List;

public class GameStart {

    private final BridgeGame bridgeGame;
    private InputView inputView;
    private OutputView outputView;
    private static int tryNum=1;
    private static boolean regame ;

    GameStart(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
        inputView = new InputView();
        outputView = new OutputView();
        regame = true;
        StartMoving();
    }

    private void StartMoving() {
        if ((bridgeGame.getBridge()).size() == (bridgeGame.getProgress1().size())) {
            regame =false;
            return;
        }
        String moving = inputView.readMoving();
        bridgeGame.move(moving);
        List<String> P1 = bridgeGame.getProgress1();
        List<String> P2 = bridgeGame.getProgress2();
        outputView.printMap(P1, P2);
        CheckOutput(P1,P2);
    }

    private void CheckOutput(List<String>P1,List<String>P2) {
        if (P1.get(P1.size() - 1).equals(" X ") || P2.get(P2.size() - 1).equals(" X ")) {
            String re = inputView.readGameCommand();
            if (bridgeGame.retry(re)) {
                tryNum+=1;
                regame = true;
                return;
            }
            regame = false;
        }
    }

    public boolean getReGame() {
        return regame;
    }


}
