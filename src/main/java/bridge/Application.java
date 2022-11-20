package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeMaker.makeBridge(3);
        OutputView outputView = new OutputView();
        outputView.printMap(BridgeMaker.bridge);
    }
}
