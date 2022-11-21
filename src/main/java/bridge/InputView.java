package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    //다리의 길이 입력
    public int readBridgeSize() {
        int bridgeSize = Integer.parseInt(Console.readLine());

        // 다리 길이 예외처리
        if(bridgeSize < 3 || bridgeSize > 20){      // 3보다 작거나 20보다 큰 경우
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }

        return bridgeSize;
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
    public boolean readGameCommand() {
        String RestartOrQuit = Console.readLine();
        if(RestartOrQuit.equals("Q"))
            return true;
        return false;
    }
}
