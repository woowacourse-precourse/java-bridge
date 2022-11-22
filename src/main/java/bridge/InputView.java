package bridge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    InputStreamReader ir = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(ir);

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeSize;
        try {
            bridgeSize = Integer.parseInt(br.readLine());
            errorBridgeSize(bridgeSize);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving;
        try {
            moving = br.readLine();
            errorMoving(moving);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand;
        try {
            gameCommand = br.readLine();
            errorGameCommand(gameCommand);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return gameCommand;
    }

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
