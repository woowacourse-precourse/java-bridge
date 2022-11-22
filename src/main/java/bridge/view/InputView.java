package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요";
    private final String NUMBER_FORMAT_ERROR = "[ERROR] 다리의 길이는 숫자입니다.";
    private final String SELECT_PLACE_MESSAGE = "이동할 칸을 선택해주세요";
    private final String SELECT_RESTART_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public int inputBridgeLength() {
        try {
            System.out.println(BRIDGE_LENGTH_MESSAGE);
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException err) {
            System.out.println(NUMBER_FORMAT_ERROR);
        }
        return 0;
    }

    public String inputMoving() {
        ;
        System.out.println(SELECT_PLACE_MESSAGE);
        return Console.readLine();
    }


}