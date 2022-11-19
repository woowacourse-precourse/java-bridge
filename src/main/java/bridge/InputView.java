package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeSize =0 ;
        try {

            bridgeSize= Integer.parseInt(Console.readLine());

            validSize(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return bridgeSize;
    }

    private void validSize(int brigeSize) {

        if ((brigeSize < 3) || (brigeSize > 20)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }

    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {

        String moving = Console.readLine();

        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {

        String command = Console.readLine();

        return command;
    }


}
