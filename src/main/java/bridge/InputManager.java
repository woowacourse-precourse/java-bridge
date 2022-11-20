package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {

    public int getBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String RawInputValue = Console.readLine();
        try {
            return Integer.parseInt(RawInputValue);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return 0;
    }

}
