package bridge.View;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private InputView() {}

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {

        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeSize;
        try {
            bridgeSize = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자여야 합니다.");
        }

        if (bridgeSize < 3 || bridgeSize > 20)
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");

        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {

        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moving;
        moving = Console.readLine();

        if (!moving.equals("U") && !moving.equals("D"))
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D로 입력할 수 있습니다.");

        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {

        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String retry;
        retry = Console.readLine();

        if (!retry.equals("R") && !retry.equals("Q"))
            throw new IllegalArgumentException("[ERROR] 재시작 여부는 R 또는 Q로 입력할 수 있습니다.");

        return retry;
    }
}
