package bridge;


public class Player {
    private String command;
    private int position;

    public Player() {
        command = null;
        position = 0;
    }

    public String getCommand() {
        validateGetCommand();
        return command;
    }

    private void validateGetCommand() {
        if (command == null) {
            throw new IllegalStateException(ErrorMessageGenerator.generate("플레이어에게 커맨드가 설정되지 않았습니다."));
        }
    }

    public void move(String command) {
        validateMove(command);
        this.command = command;
        this.position += 1;
    }

    private static void validateMove(String command) {
        if (!command.equals(BridgeGame.CMD_DOWN) && !command.equals(BridgeGame.CMD_UP)) {
            throw new IllegalStateException(ErrorMessageGenerator.generate("올바르지 않은 move 명령어입니다."));
        }
    }

    public int getIndex() {
        return position - 1;
    }

    public int getPosition() {
        return position;
    }
}
