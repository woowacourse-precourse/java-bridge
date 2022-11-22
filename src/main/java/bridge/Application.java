package bridge;
public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        GameManager gameManager = new GameManager(bridgeMaker);
        gameManager.play();
    }
}
