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

            outputView.printResult(bridgeGame, playGame(bridgeGame));
        } catch (NumberFormatException e){
            System.out.println(errorMessage + ' ' + "숫자만 입력해주세요.");
        } catch (IllegalArgumentException e) {
            System.out.println(errorMessage + ' ' + e.getMessage());
        }
    }

    /**
     * 게임을 한판 진행하는 메서드
     * @param bridgeGame 현재 진행되는 브릿지게임
     * @return 클리어 여부
     */
    private static boolean playGame(final BridgeGame bridgeGame) {
        for(int i = 0; i < bridgeGame.getBridgeSize(); i++) {
            boolean moveSuccess = bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame, moveSuccess);

            if(!moveSuccess)
                return gameover(bridgeGame);
        }
        return true;
    }

    /**
     * 게임 오버 시 진행되는 메서드
     * @param bridgeGame 현재 진행되는 브릿지게임
     * @return 클리어 여부
     */
    private static boolean gameover(BridgeGame bridgeGame) {
        if(bridgeGame.retry(inputView.readGameCommand()))
            return playGame(bridgeGame);
        return false;
    }
}
