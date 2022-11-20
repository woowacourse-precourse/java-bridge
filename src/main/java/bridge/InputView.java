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

        int bridgeSize = 0;
        try {
            bridgeSize = Integer.parseInt(Console.readLine());
            if (bridgeSize < 3 || bridgeSize > 20) {
                System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
                bridgeSize = readBridgeSize();
            }
        } catch (IllegalStateException | IllegalArgumentException exception) {
            System.out.println("[ERROR] 숫자를 입력해주세요");
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = null;
        try {
            moving = Console.readLine().toUpperCase();
            return moving;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new IllegalStateException("[ERROR]");
        } catch (IllegalStateException e) {
            throw new IllegalStateException("[ERROR]");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return Console.readLine().toUpperCase();
    }
}
