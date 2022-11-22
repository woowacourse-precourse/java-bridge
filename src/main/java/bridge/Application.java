package bridge;

public class Application {
    static final InputView inputView = new InputView();
    static final OutputView outputView = new OutputView();
    static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public static void main(String[] args) {
        try {
            playGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void playGame() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        while (tryOnce(bridgeGame)) {
            bridgeGame.retry();
        }
        System.out.println("최종 게임 결과");
        outputView.printMap(bridgeGame.getBridge(), bridgeGame.getUserMove());
        outputView.printResult(bridgeGame.isClear(), bridgeGame.getTryNumber());
    }

    /**
     * 게임을 1회 시도하는 메서드
     *
     * @return 게임을 재시작 해야하는지 여부. 건너다 실패하고 R을 입력한 경우 true를 반환한다.
     * 게임을 클리어하거나, 건너다 실패하고 Q를 입력한 경우 false를 반환한다.
     */
    public static boolean tryOnce(BridgeGame bridgeGame) {
        while (!bridgeGame.isClear()) {
            boolean lastMoveSuccess = bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getBridge(), bridgeGame.getUserMove());
            if (!lastMoveSuccess) {
                return inputView.readGameCommand().equals("R");
            }
        }
        return false;
    }
}
