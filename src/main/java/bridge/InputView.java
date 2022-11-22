package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     * @return 입력받은 다리 크기를 반환한다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String bridgeSizeStr = Console.readLine();
        if(!bridgeSizeStr.matches("\\d{1,2}"))
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");

        int bridgeSize = Integer.parseInt(bridgeSizeStr);
        if (bridgeSize < 3 || bridgeSize > 20)
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");

        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     * @return 이동할 다리를 반환한다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");

        String movingStr = Console.readLine();
        if (!movingStr.matches("[UD]"))
            throw new IllegalArgumentException("[ERROR] 윗 칸을 움직이려면 'U', 아랫 칸을 움직이려면 'D'를 입력하여 주십시오.");

        return movingStr;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     * @return 게임 진행 여부의 값을 반환한다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        String gameCommand = Console.readLine();
        if (!gameCommand.matches("[RQ]"))
            throw new IllegalArgumentException("[ERROR] 재시도하려면 'R', 게임을 종료하려면 'Q'를 입력하여 주십시오.");

        return gameCommand;
    }
}
