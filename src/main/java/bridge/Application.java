package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            BridgeGame bridgeGame = new BridgeGame();
            bridgeGame.initialize();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
