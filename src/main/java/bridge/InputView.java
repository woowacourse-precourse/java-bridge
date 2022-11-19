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
        startGame();
        try {
            int input = Integer.parseInt(Console.readLine());
            if(input < 3 || input > 20) throw new NumberFormatException();
            return input;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println();
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        if(!(input.equals("U") || input.equals("D"))) {
            System.out.println("[ERROR] 이동할 칸은 'U' 혹은 'D' 이여야 합니다.");
            throw new IllegalArgumentException();
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println();
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = Console.readLine();
        if(!(input.equals("R") || input.equals("Q"))) {
            System.out.println("[ERROR] 다시 시도할지 여부는 'Q' 혹은 'R' 이여야 합니다.");
            throw new IllegalArgumentException();
        }
        return input;
    }

    private void startGame() {
        System.out.println("다리 건너기 게임을 시작합니다.\n" +
                "\n" +
                "다리의 길이를 입력해주세요.");
    }
}
