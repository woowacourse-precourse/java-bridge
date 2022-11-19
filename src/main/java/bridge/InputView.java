package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = camp.nextstep.edu.missionutils.Console.readLine();
        // input 오류처리 필요(숫자 아닌값 입력, 3이상 20이하 범위 벗어난 경우)
        return Integer.parseInt(bridgeSize);
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

    public void checkNotDigit(String str) throws IllegalArgumentException {
        for (int i = 0; i < str.length(); i++) {
            char charUnit = str.charAt(i);
            if ((int) charUnit < 48 || (int) charUnit > 58) {
                throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자여야 합니다");
            }
        }
    }

    public void checkOutOfBound(int bridgeSize) throws IllegalArgumentException {
        if ((bridgeSize < 3) || (bridgeSize > 20)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public Boolean errorHandling(String str) {
        try {
            checkNotDigit(str);
            checkOutOfBound(Integer.parseInt(str));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        return true;
    }

}
