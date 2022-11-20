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
            throw new IllegalArgumentException(ErrorMessageGenerator.generate("플레이어에게 커맨드가 설정되지 않았습니다."));
        }
    }

    public int getIndex() {
        return position - 1;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
