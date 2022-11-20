package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        try {
            Integer bridgeSize = Integer.valueOf(Console.readLine());
            validateBridgeSize(bridgeSize);
            return bridgeSize;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            throw new NoSuchElementException();
        }
    }

    private void validateBridgeSize(Integer bridgeSize) {
        if(bridgeSize < 3 || bridgeSize > 20) throw new NumberFormatException();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String move = Console.readLine();
        validateMove(move);
        return move;
    }

    private void validateMove(String move) {
        if (!(move.equals("U") || move.equals("D"))) {
            System.out.println("[ERROR] 이동할 칸은 'U' 혹은 'D'로만 입력해주세요.");
            throw new NoSuchElementException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand = Console.readLine();
        validateGameCommand(gameCommand);
        return gameCommand;
    }

    private void validateGameCommand(String gameCommand) {
        if (!(gameCommand.equals("R") || gameCommand.equals("Q"))) {
            System.out.println("[ERROR] 재시도 여부는 'R' 혹은 'Q'로만 입력해주세요.");
            throw new NoSuchElementException();
        }
    }
}
