package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class InputManager {
    private final String MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String BRIDGE_MAKE_MASSAGER = "다리의 길이를 입력해주세요.";


    public String getMovingWay() {
        System.out.println(MOVE_MESSAGE);
        String movingWay = Console.readLine();
        validateWay(movingWay);
        return movingWay;
    }



    private void validateWay(String rawInput) {
        if (!Objects.equals(rawInput, "U") && !Objects.equals(rawInput, "D")) {
            throw new IllegalArgumentException("[ERROR] U 혹은 D 를 입력해야합니다. (대,소문자 구분)");
        }
    }

    public int getBridgeSize() {
        System.out.println(BRIDGE_MAKE_MASSAGER);
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
