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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return gameCommand;
    }
}
