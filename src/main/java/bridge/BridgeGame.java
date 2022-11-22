package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.GameEndChecker;
import bridge.domain.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private final BridgeMaker bridgeMaker;
    private final GameEndChecker gameEndChecker;
    private final Player player;

    public BridgeGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(this.bridgeRandomNumberGenerator);
        this.gameEndChecker = new GameEndChecker();
        this.player = new Player();
    }

    public void play() {
        System.out.println("게임 시작");
        int bridgeSize = inputView.readBridgeSize();
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        while (!gameEndChecker.getEnd()) {
            System.out.println(bridge.getBridge());
            crossBridge(bridge);
        }
        outputView.printResult(player);
    }

    private void crossBridge(Bridge bridge) {
        // TODO: 함수길이 초과 리팩토링 요망
        for (int i = 0; i < bridge.getBridgeSize(); i++) {
            String moving = move(bridge, i);
            outputView.printMap(bridge, i, moving);
            if (!bridge.canMove(i, moving)) {
                player.addGameCount();
                retry();
                return;
            }
        }
        gameEndChecker.setEnd(true);
        player.setGameClear(true);
    }

    public String move(Bridge bridge, int index) {
        System.out.println("이동 입력");
        String moving = inputView.readMoving();
        return moving;
    }

    public void retry() {
        System.out.println("게임 재시작 유무");
        String answer = inputView.readGameCommand();
        quit(answer);
    }

    private void quit(String answer) {
        // TODO: Enum으로 리팩토링
        if (answer.equals("Q")) {
            gameEndChecker.setEnd(true);
        }
    }
}
