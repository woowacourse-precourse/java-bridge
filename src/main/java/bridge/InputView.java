package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String inputString = camp.nextstep.edu.missionutils.Console.readLine();

        int bridgeSize = checkBridgeSize(inputString);

        return bridgeSize;
    }

    public int checkBridgeSize(String inputString) {
        try {
            int inputInteger = Integer.parseInt(inputString);
            if (inputInteger < 3 || inputInteger > 20) {
                throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
            return inputInteger;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String inputString = camp.nextstep.edu.missionutils.Console.readLine();

        return checkMoving(inputString);
    }

    public String checkMoving(String inputString) {
        if (inputString.equals("U") || inputString.equals("D")) {
            return inputString;
        }
        throw new IllegalArgumentException("[ERROR] 이동할 칸은 U나 D여야 합니다.");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
