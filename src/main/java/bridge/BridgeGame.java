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


    public void move(String gameCommand) {
        if (!(gameCommand.equals("U") || gameCommand.equals("D"))) throw new IllegalArgumentException();
    }


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
