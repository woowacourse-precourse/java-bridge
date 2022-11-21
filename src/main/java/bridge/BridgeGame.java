package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeMaker bridgeMaker;

    private GameSimulation game;
    private List<String> bridge;

    public BridgeGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void run() {
        gameSituation();
        do {
            move();
        }
        while (checkEnd());
    }

    private void gameSituation() {
        int bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    private boolean checkEnd() {
        if (!game.isSuccess() && retry().equals("R")) {
            return true;
        }
        return false;
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        while (true) {
            int location = game.getLocation();
            if (checkMove(location, bridge.size())) {
                break;
            }
            moveNext(location);
            game.addLocation();
        }
    }

    private boolean checkMove(int location, int size) {
        if (game.getLocation() == size) {
            game.setSuccess(true);
            return true;
        }
        if (game.getAnswer().equals("X")) {
            return true;
        }
        return false;
    }

    private void moveNext(int status) {
        String direction = inputView.readMoving();
        String input = input(direction, game.getbridge().get(status));
    }

    private String input(String user, String answer) {
        if (!user.equals(answer)) {
            return "X";
        }
        return "O";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String retry() {
        String command = "";
        command = inputView.readGameCommand();
        return command;
    }
}
