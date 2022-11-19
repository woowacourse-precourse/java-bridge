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
        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeSize;
        try {
            bridgeSize = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }

        if (!validateBridgeSize(bridgeSize)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }

        return bridgeSize;
    }

    private boolean validateBridgeSize(int bridgeSize) {
        return (bridgeSize >= 3 && bridgeSize <= 20);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moving = Console.readLine();
        if (!validateMoving(moving)) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U(위 칸)와 D(아래 칸) 중 하나의 문자여야 합니다.");
        }

        return moving;
    }

    private boolean validateMoving(String moving) {
        return (moving.equals("U") || moving.equals("D"));
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand = Console.readLine();

        return gameCommand;
    }
}
