package bridge;

public class Error {
    public void errorBridgeSize(int bridgeSize) {
        if (bridgeSize > 20 || bridgeSize < 3) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이가 3~20 사이에 포함되지 않습니다.");
        }
    }

    public void errorMoving(String moving) {
        if (moving.equals("D") || moving.equals("U")) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 이동할 칸이 올바르지 않습니다.");
    }

    public void errorGameCommand(String gameCommand) {
        if (gameCommand.equals("R") || gameCommand.equals("Q")) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 재시작/종료 여부가 올바르지 않습니다.");
    }
}
