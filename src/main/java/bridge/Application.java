package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            System.out.println("다리 건너기 게임을 시작합니다.");
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            BridgeGame bridgeGame = new BridgeGame(bridgeMaker);
            bridgeGame.play();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
