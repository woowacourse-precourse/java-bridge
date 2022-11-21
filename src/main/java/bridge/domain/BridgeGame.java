package bridge.domain;

import bridge.constant.Constant;
import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private InputView inputView;
    private OutputView outputView;
    private BridgeMaker bridgeMaker;
    private Player player;
    private Bridge bridge;
    private final List<String> status;
    private boolean gamestatus;

    private int attempt;


    public BridgeGame() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        inputView = new InputView();
        outputView = new OutputView();
        player = new Player();
        status = new ArrayList<>();
        gamestatus = false;
    }

    public void play() {
        int bridgeSize = inputView.readBridgeSize();
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        do {
            String inputMoving = inputView.readMoving();
            move(inputMoving);

        } while (!gameOver());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        player.movePlayer(moving);
        List<String> playerMoving = player.getPlayerMoving();
        if (!bridge.isMove(playerMoving, playerMoving.size() - 1)) {
            status.add("X");
            gamestatus = true;
            return;
        }
        status.add("O");
        outputView.printMap(bridge.getBridge(), status);
    }

    private boolean gameOver() {
        return gamestatus || status.size() == bridge.getBridgeSize();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
