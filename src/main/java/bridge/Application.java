package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean success = false;
        Controller controller = new Controller();
        BridgeGame bridgeGame = controller.start();
        while(true){
            while(controller.play(bridgeGame));
            if (!controller.finish(bridgeGame) || bridgeGame.check()){
                success = true;
                break;
            }
        }
        controller.result(bridgeGame, success);
    }
}
