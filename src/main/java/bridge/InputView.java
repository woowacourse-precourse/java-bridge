package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = readLine();
        try {
            int bridgeSize =  checkBridgeSize(input);
            return bridgeSize;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return 0;
        }
    }

    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = readLine();
        try{
            String moving = checkMoving(input);
            return moving;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return "null";
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    public int checkBridgeSize(String input) {
        String replacedInput = input.replaceAll("[^0-9]", "");
        if (!input.equals(replacedInput)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력이 가능합니다.");
        }
        int bridgeSize = Integer.parseInt(replacedInput);
        if (bridgeSize<3 || bridgeSize>20) {
            throw new IllegalArgumentException("[ERROR] 3이상 20이하의 숫자만 입력이 가능합니다.");
        }
        return bridgeSize;
    }

    public String checkMoving(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] U 혹은 D만 입력이 가능합니다.");
        }
        return input;
    }
}
