package bridge;

import bridge.maker.BridgeMaker;
import bridge.maker.BridgeRandomNumberGenerator;
import bridge.ui.InputView;
import bridge.ui.OutputView;

import java.util.List;

public class Application {
    final static InputView inputView = new InputView();
    final static OutputView outputView = new OutputView();
    final static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    final static BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    final static String errorMessage = "[ERROR]";

    public static void main(String[] args) {
        try {
            List<String> stageBridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
            BridgeGame bridgeGame = new BridgeGame(stageBridge);
            System.out.println(stageBridge.toString());  // TODO 지워야한다
            playGame(bridgeGame);
        } catch (IllegalArgumentException e) {
            System.out.println(errorMessage + e.getMessage());
        }
    }

    /**
     * 게임을 한판 진행하는 메서드
     * @param bridgeGame 현재 진행되는 브릿지게임
     */
    private static void playGame(final BridgeGame bridgeGame) {
        for(int i = 0; i < bridgeGame.getBridgeSize(); i++) {
            boolean moveSuccess = bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getPlayLog(), moveSuccess);

            if(!moveSuccess){
                gameover(bridgeGame);
                break;
            }
        }
    }

    /**
     * 게임 오버 시 진행되는 메서드
     * @param bridgeGame 현재 진행되는 브릿지게임
     */
    private static void gameover(BridgeGame bridgeGame) {
        if(bridgeGame.retry(inputView.readGameCommand()))
            playGame(bridgeGame);
    }

}
