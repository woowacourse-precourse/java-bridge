package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            try {
                System.out.println("다리의 길이를 입력해주세요.");
                return Integer.parseInt(readLineByComplianceWithPattern("^\\d+$"));
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자만 입력해주세요.");
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            try {
                System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
                return readLineByComplianceWithPattern("^[UD]{1}$");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] U혹은 D만 입력해주세요.");
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            try {
                System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                return readLineByComplianceWithPattern("^[RQ]{1}$");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] R혹은 Q만 입력해주세요.");
            }
        }
    }

    private String readLineByComplianceWithPattern(String pattern) {
        String line = Console.readLine();
        if (!line.matches(pattern)) {
            throw new IllegalArgumentException();
        }
        return line;
    }

}
