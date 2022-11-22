package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");

        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 입력 받은 다리의 길이가 정수가 아닙니다.");
        }
    }

    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();

        if (input.equals("U") || input.equals("D")) {
            return input;
        }

        throw new IllegalArgumentException("[ERROR] 입력 받은 이동할 칸이 U나 D가 아닙니다.");
    }

    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = Console.readLine();

        if (input.equals("R") || input.equals("Q")) {
            return input;
        }

        throw new IllegalArgumentException("[ERROR] 입력 받은 재시도 여부가 R이나 Q가 아닙니다.");
    }
}
