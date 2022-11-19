package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("다리 건너기 게임을 시작합니다.");
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        int ladderLen = inputView.readBridgeSize();
        System.out.println("ladderLen = " + ladderLen);
        BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker maker = new BridgeMaker(generator);
        List<String> ladder = maker.makeBridge(ladderLen);
        System.out.println("ladder = " + ladder);
        BridgeGame bridgeGame = new BridgeGame(inputView, outputView);
        bridgeGame.move(ladder);
//
//        System.out.println("UD = " + UD);
//        String RQ = inputView.readGameCommand();
    }
}
