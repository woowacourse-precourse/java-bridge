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
        int bridgeSize = Integer.parseInt(readLine());
        if ((bridgeSize < 3) || (bridgeSize > 20))
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moving = readLine();
        if(!"UD".contains(moving)) {
            throw new IllegalArgumentException("[ERROR] 사용자는 'U' 혹은 'D'를 통해서만 이동할 수 있습니다.");
        }
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand = readLine();
        if(!"RQ".contains(gameCommand)) {
            throw new IllegalArgumentException("[ERROR] 사용자는 'R' 혹은 'Q'를 통해서만 게임을 다시 시도할지 여부를 입력할 수 있습니다.");
        }
        return gameCommand;
    }
}
