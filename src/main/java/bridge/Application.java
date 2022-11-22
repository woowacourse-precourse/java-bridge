package bridge;


public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            BridgeController bridgeController = new BridgeController();
            BridgeGame bridgeGame = bridgeController.doBridgeMake();
            while (true) if(!bridgeController.doBridgeMove(bridgeGame)) break;

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
