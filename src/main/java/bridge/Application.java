package bridge;


import java.util.List;

public class Application {

    static final String START_GAME = "다리 건너기 게임을 시작합니다. \n";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(START_GAME);
        int bridgeSize = InputView.readBridgeSize();
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridgeshape =  bridgeMaker.makeBridge(bridgeSize);

        String selectMove = InputView.readMoving();
        System.out.println(BridgeGame.move(selectMove, bridgeshape));

    }
}
