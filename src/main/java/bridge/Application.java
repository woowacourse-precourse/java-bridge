package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();

            // 게임 시작 문구를 출력하는 기능
            outputView.printGameStart();

            // 다리 길이 입력받는 기능
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            int size = inputView.readBridgeSize();
            Bridge bridge = new Bridge(bridgeMaker.makeBridge(size));

            // 플레이어가 이동할 칸을 입력받는 기능
            BridgeGame bridgeGame = new BridgeGame(bridge);
            User user = new User();
            int status;
            do {
                String moveCommand = inputView.readMoving();
                status = bridgeGame.move(moveCommand);
                user.addResult(status, moveCommand);
                outputView.printMap(user.getMoveResult());
            } while (status == BridgeGame.KEEP_GOING);

            // 재시작 / 종료 명령을 입력받는 기능
            String gameCommand = inputView.readGameCommand();
            bridgeGame.retry(gameCommand);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
