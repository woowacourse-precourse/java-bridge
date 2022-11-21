package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String bridgeSize = readLine();
        try {
            isValidateValue(bridgeSize);
            isValidateRange(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            readBridgeSize();
        }
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String bridgeUD = readLine();
        try {
            isValidateUD(bridgeUD);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            readMoving();
        }
        return bridgeUD;
    }
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
    public void isValidateValue(String size) {
        try {
            Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]: 정수로 변환될 수 없음");
        }
    }
    public void isValidateRange(String size) {
        int bridgeSize = Integer.parseInt(size);
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR]: 범위 초과 3~20사이로 재입력");
        }
    }
}