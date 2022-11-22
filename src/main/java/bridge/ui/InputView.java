package bridge.ui;

import static bridge.constant.BridgeRule.MAXIMUM_SIZE;
import static bridge.constant.BridgeRule.MINIMUM_SIZE;

import bridge.constant.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String NO_LETTER = "";

    public int readBridgeSize() {
        try {
            int bridgeSize = getBridgeSizeAfterAnnounce();
            validateSize(bridgeSize);
            return bridgeSize;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    private int getBridgeSizeAfterAnnounce() {
        System.out.println(INPUT_BRIDGE_SIZE);
        int bridgeSize = readBridgeSizeInputAfterParse();
        System.out.println(NO_LETTER);
        return bridgeSize;
    }

    private int readBridgeSizeInputAfterParse() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.INPUT_ONLY_NUMBER_FORMAT.getValue(), MINIMUM_SIZE, MAXIMUM_SIZE));
        }
    }

    private void validateSize(int size) {
        if (MINIMUM_SIZE <= size && size <= MAXIMUM_SIZE) {
            return;
        }
        throw new IllegalArgumentException(
                String.format(ErrorMessage.WRONG_BRIDGE_SIZE_FORMAT.getValue(), MINIMUM_SIZE, MAXIMUM_SIZE));
    }

    public String readMoving() {
        System.out.println(INPUT_MOVING);
        String moving = Console.readLine();
        return moving;
    }

    public String readGameCommand() {
        System.out.println(INPUT_GAME_COMMAND);
        String gameCommand = Console.readLine();
        return gameCommand;
    }
}
