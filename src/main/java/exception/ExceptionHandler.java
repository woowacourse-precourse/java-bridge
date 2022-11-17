package exception;



public class ExceptionHandler {
    private int size;
    private String gameCommand;

    public ExceptionHandler(int size) {
        this.size = size;
        checkBridgeSize(size);
    }

    public ExceptionHandler(String gameCommand) {
        this.gameCommand = gameCommand;
        checkBridgeMove(gameCommand);
    }

    public void checkBridgeSize(int size) {
        if (!(size >= 3 && size <= 20)) throw new IllegalArgumentException();
    }

    public void checkBridgeMove(String moveBridge) {
        if (!(moveBridge.equals("Q") || moveBridge.equals("R"))) throw new IllegalArgumentException();
    }

    public int getSize() {
        return size;
    }

    public String getGameCommand() {
        return gameCommand;
    }
}
