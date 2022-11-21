package bridge;


import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> b = bridgeMaker.inputAndMakeBridge();
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.play(b);
    }
}
