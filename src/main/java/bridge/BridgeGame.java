package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private String gameCommand; //U or D
    private String retryCommand; //R or Q
    private int size; // 다리 길이

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
        if (!(gameCommand.equals("U") || gameCommand.equals("D"))) {
            throw new IllegalArgumentException();
        }
    }

    public void retry(String retryCommand) {
        if (!(retryCommand.equals("Q") || retryCommand.equals("R"))) {
            throw new IllegalArgumentException();
        }
    }

    public void checkBridgeSize(int size) {
        if (!(size >= 3 && size <= 20)) throw new IllegalArgumentException();
    }

    public int getSize() {
        return size;
    }

    public String getReadMoving() {
        return gameCommand;
    }

    public String getGameCommand() {
        return retryCommand;
    }

}
