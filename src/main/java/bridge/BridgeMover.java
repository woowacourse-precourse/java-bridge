package bridge;

public class BridgeMover {
    public String requestReadMoving() {
        InputView inputView = new InputView();
        String moveCommand = inputView.readMoving();
        try {
            isValidMove(moveCommand);
        } catch (IllegalArgumentException e) {
            e.getMessage();
            moveCommand = inputView.readMoving();
        }
        return moveCommand;
    }
    public boolean isValidMove(String moveCommand) {
        if(!(moveCommand.equals("U") || moveCommand.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] 알맞은 이동 명령이 아닙니다.");
        }
        return true;
    }
}
