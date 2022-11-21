package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    //다리의 길이를 입력받는다.
    public int readBridgeSize() {
        int bridgelength = 0;

        System.out.println("다리의 길이를 입력해주세요.");
        try {
            bridgelength = Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR]");
        }

        return bridgelength;
    }

    //사용자가 이동할 칸을 입력받는다.
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moving = Console.readLine();
        return moving;
    }

    //사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String exittype = Console.readLine();
        return exittype;
    }
}
