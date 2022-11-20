package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {

    public int getBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String RawInputValue = Console.readLine();
        int bridgeSize = validateNumber(RawInputValue);
        numberRangeCheck(bridgeSize);
        return bridgeSize;
    }

    private Integer validateNumber(String RawInputValue) {
        try {
            return Integer.parseInt(RawInputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }


    private void numberRangeCheck(int bridgeSize) {
        if (bridgeSize > 20 || 3 > bridgeSize) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}
