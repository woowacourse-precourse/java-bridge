package bridge;

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
            playGame(bridgeGame);
        } catch (IllegalArgumentException e) {
            System.out.println(errorMessage + e.getMessage());
        }
    }

    /**
     * 게임을 한판 진행하는 메서드
     * @param bridgeGame 현재 진행되는 브릿지게임
     * @return 유저가 끝까지 도달하였는지 확인 (true : 도달 성공, false : 도달 실패)
     */
    private static boolean playGame(final BridgeGame bridgeGame) {
        for(int i = 0; i < bridgeGame.getBridgeSize(); i++) {
            boolean moveSuccess = bridgeGame.move(inputView.readMoving());
            outputView.printMap();

            if(!moveSuccess)
                return false;
        }
        return true;
    }

}
