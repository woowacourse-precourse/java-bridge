package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedReader;
//import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int BridgeSize = Integer.parseInt(Console.readLine());

        if(BridgeSize < 3 || BridgeSize>20)
            throw new IllegalArgumentException("[ERROR]");

        return BridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {

        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
