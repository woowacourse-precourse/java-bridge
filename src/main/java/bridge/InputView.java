package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException{
        try {
            String line = Console.readLine();
            int bridgeSize = Integer.parseInt(line);
            validBridgeSize(bridgeSize);
            return bridgeSize;
        } catch (IllegalArgumentException | NoSuchElementException e){
            throw new IllegalArgumentException(e.getMessage());
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
    public String readGameCommand() {
        return null;
    }

    private void validBridgeSize(int bridgeSize){
        if (bridgeSize < 3 || bridgeSize > 20){
            throw new NoSuchElementException("3 ~ 20 사이의 값만 입력 가능합니다.");
        }
    }
}
