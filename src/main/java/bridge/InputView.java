package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private int bridgeSize;
    //다리의 길이 입력
    public int readBridgeSize() {
        bridgeSize = Integer.parseInt(Console.readLine());

        validateBridge(bridgeSize);
        return bridgeSize;
    }

    public void validateBridge(int bridge){
        // 다리 길이 예외처리
        if(bridge < 3 || bridge > 20){      // 3보다 작거나 20보다 큰 경우
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }

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
