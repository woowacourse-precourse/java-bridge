package bridge.view;

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
            validateBridgeSize(Integer.parseInt(bridgeSize));
        } catch (NumberFormatException n) {
            System.out.println("[ERROR] 숫자가 아닌 문자가 입력되었습니다.");
            return readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            return readBridgeSize();
        }
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moving = readLine();
        try {
            validateMoving(moving);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] U나 D 중 하나를 선택해주세요");
            return readMoving();
        }
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand = readLine();
        try {
            validateGameCommand(gameCommand);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] R이나 Q 중 하나를 입력해주세요.");
            return readGameCommand();
        }
        return gameCommand;
    }

    private void validateBridgeSize(int bridgeSize) {
        if (!(bridgeSize <= 20) || !(bridgeSize >= 3)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private void validateMoving(String moving) {
        if (!moving.equals("U") && !moving.equals("D")) {
            throw new IllegalArgumentException("[ERROR] U나 D 중 하나를 선택해주세요.");
        }
    }

    private void validateGameCommand(String gameCommand) {
        if (!gameCommand.equals("R") && !gameCommand.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] R이나 Q 중 하나를 입력해주세요.");
        }
    }
}
