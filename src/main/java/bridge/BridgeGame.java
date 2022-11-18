package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */

// TODO BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.

public class BridgeGame {
    private String gameCommand;
    private String retryCommand;
    private int size;



    public BridgeGame(String gameCommand, String retryCommand) {
        this.gameCommand = gameCommand;
        this.retryCommand = retryCommand;
        move(gameCommand);
        retry(retryCommand);
    }

    public BridgeGame(int size) {
        this.size = size;
        checkBridgeSize(size);
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String gameCommand) {
        if (!(gameCommand.equals("U") || gameCommand.equals("D"))) throw new IllegalArgumentException();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String retryCommand) {
        if (!(retryCommand.equals("Q") || retryCommand.equals("R"))) throw new IllegalArgumentException();
    }

    public void checkBridgeSize(int size) {
        if (!(size >= 3 && size <= 20)) throw new IllegalArgumentException();
    }


    public String getReadMoving() {
        return gameCommand;
    }

    public String getGameCommand() {
        return retryCommand;
    }

    public int getSize() {
        return size;
    }
}
