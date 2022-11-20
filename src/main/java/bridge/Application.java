package bridge;

public class Application {

    private static InputView input;
    private static OutputView output;
    private static BridgeGame game;

    /**
     * 게임 시작 화면 구성 후 다리 길이를 입력받아 랜덤 다리를 생성한다.
     */
    private static void start(){
        output.printStart();
        game.makeBridgeGame(input.readBridgeSize());
    }

    public static void main(String[] args) {
        start();
    }
}
