package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {


    /**
     * 게임 시작 메서드
     */
    public void start() {
        int size = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(size);
        player = new ArrayList<>();
        tryCount += 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public String move() {
        String moving = inputView.readMoving();
        player.add(moving);
        outputView.printMap(bridge, player);

        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public boolean retry() {
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals("R")) {
            tryCount += 1;
            player = new ArrayList<>();
            return true;
        }
        return false;
    }
    }
}
