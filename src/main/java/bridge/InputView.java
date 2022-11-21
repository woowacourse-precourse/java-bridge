package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String inputBridgeSize = Console.readLine();
        return inputBridgeSize;
    }

    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String inputUpDown = Console.readLine();
        return inputUpDown;
    }

    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String inputRQ = Console.readLine();
        return inputRQ;
    }
}