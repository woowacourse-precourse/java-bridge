package bridge.Controller;

import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.User;
import bridge.domain.Map;
import bridge.service.GameService;
import bridge.view.InputView;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private GameService gameService;

    public void play() {
        set();
        move();
    }

    public void set() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        User user = new User();
        Map map = new Map();
        gameService = new GameService(bridgeMaker.makeBridge(InputView.readBridgeSize()), user, map);
    }

    public void move() {
        boolean proceed = true;
        while (proceed) {
            gameService.move(InputView.readMoving());
            OutputView.printMap(gameService.drawMap());
            proceed = gameService.CanKeepGoingGame();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
