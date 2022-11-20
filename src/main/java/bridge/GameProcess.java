package bridge;

import bridge.domain.Bridge;
import bridge.game.BridgeGame;
import bridge.domain.User;
import bridge.view.InputView;
import bridge.view.OutputView;


public class GameProcess {
    private BridgeGame bridgeGame;
    private InputView inputView;
    private OutputView outputView;

    public GameProcess(BridgeGame bridgeGame, InputView inputView, OutputView outputView) {
        this.bridgeGame = bridgeGame;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        User user = new User();
        boolean gameStart = true;

        run(gameStart, bridgeGame.construct(
                ()->inputView.readBridgeSize(error -> outputView.printError(error.getMessage()))), user);

        outputView.printResult(user);
    }

    private void run(Boolean gameStart, Bridge bridge, User user) {
        outputView.println("다리 건너기 게임을 시작합니다.");

        while (gameStart) {
            setUp(user);
            play(bridge, user);
            gameStart = endRound(bridge, user);
        }
    }

    private void setUp(User user) {
        user.startRound();
    }

    private void play(Bridge bridge, User user) {
        // 사용자 이동
        bridgeGame.move(bridge,
                () -> inputView.readMoving((e) -> outputView.printError(e.getMessage())),
                (index, way) -> {
                    user.move(bridge.getMap(), index, way);
                    outputView.printMap(user);
                });
    }

    private Boolean endRound(Bridge bridge, User user) {
        Boolean gameStart;
        // 실패시 재시작 여부
        gameStart = bridgeGame.retry(bridge, user,
                () -> inputView.readGameCommand(e -> outputView.printError(e.getMessage())));
        return gameStart;
    }
}
