package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public int readBridgeSize() {
        String bridgesSize = readLine();
        notNumber(bridgesSize);
        validateBridgeSize(Integer.valueOf(bridgesSize));
        return Integer.valueOf(bridgesSize);
    }
    private void notNumber(String bridgesSize){
        try {
            Double.parseDouble(bridgesSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
    }

    private void validateBridgeSize(int numbers) {
        if (numbers<3 || numbers>20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이를 3이상 20이하로 입력 하세요.");
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
}
