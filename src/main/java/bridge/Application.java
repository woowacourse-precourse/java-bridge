package bridge;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        int bridgeSize = inputView.readBridgeSize();
        String moveSpaceAnswer = inputView.readMoving();

        System.out.println("다리 생성 결과");
        System.out.println(bridgeMaker.makeBridge(bridgeSize));
    }
}
