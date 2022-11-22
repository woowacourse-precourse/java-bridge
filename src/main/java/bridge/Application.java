package bridge;

public class Application {

    static BridgeController bridgeController =
            new BridgeController(new BridgeRandomNumberGenerator());

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        init();
        play(true);
    }
    public static void init(){
        bridgeController.initGame();
    }
    public static void play(boolean play){
        bridgeController.playGame(play);
    }
}
