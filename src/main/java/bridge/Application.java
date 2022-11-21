package bridge;

public class Application {
    public static void main(String[] args) {
        try {
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
            Player player = new Player();
            System.out.println("다리 건너기 게임을 시작합니다.");
            while (!bridgeGame.isSucceeds()) {
                playGame(bridgeGame, player, inputView, outputView);
                if (bridgeGame.isSucceeds()) {
                    break;
                }
                if (!bridgeGame.retry(inputView.readGameCommand())) { // 중간에 실패한 경우
                    break;
                }
                player = new Player();
            }
            outputView.printResult(player.generateMap(), bridgeGame);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void playGame(BridgeGame bridgeGame, Player player, InputView inputView, OutputView outputView) {
        int totalRounds = bridgeGame.getTotalRounds();
        for (int round = 0; round < totalRounds; round++) {
            boolean isAnswer = bridgeGame.move(player, inputView.readMoving());
            // moving 결과 출력
            outputView.printMap(player.generateMap());
            if (!isAnswer) {
                return;
            }
        }
        bridgeGame.makeSuccess();
    }
}
