package bridge;

public class Application {
    public static InputView inputView = new InputView();
    final static BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    public static BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        createBridge();
    }

    public static void createBridge(){
        inputView.readBridgeSize();
        BridgeGame.bridge_answer = bridgeMaker.makeBridge(inputView.getSize());
        BridgeGame.playBridgeGame();
    }


}
