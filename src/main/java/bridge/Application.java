package bridge;

public class Application {
    final static InputView inputView = new InputView();
    final static OutputView outputView = new OutputView();
    final static BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.\n");



        try{
            bridgeGame.StartGame(inputView.readBridgeSize());
            while(bridgeGame.playing()) {
                bridgeGame.move(inputView.readMoving());
                outputView.printMap(bridgeGame.getCurStep(), bridgeGame.isDead());
                if(bridgeGame.isDead()) {
                    String command = inputView.readGameCommand();
                    bridgeGame.retry(command);
                    outputView.outputReset(command);
                }
            }

            outputView.printResult(bridgeGame.isDead(), bridgeGame.getTotalTry());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // TODO: 프로그램 구현
    }
}
