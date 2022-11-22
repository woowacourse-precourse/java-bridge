package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.constant.enumtype.BridgeGameRule;
import bridge.constant.enumtype.BridgeLengthInclusive;
import bridge.constant.enumtype.UIMessage;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(UIMessage.REQUEST_INPUT_BRIDGE_LENGTH.getValue());
        return validateReadBridgeSize(readLine());
    }

    private Integer validateReadBridgeSize(String bridgeSize) {
        Integer parsedBridgeSize = validateNumberFormat(bridgeSize);
        vaildateBridgeSizeInclusive(parsedBridgeSize);
        return  parsedBridgeSize;
    }

    private Integer validateNumberFormat(String bridgeSize) {
        Integer parsedBridgeSize = 0;
        try {
            parsedBridgeSize = Integer.parseInt(bridgeSize);
        } catch (NumberFormatException exception) {
//            System.out.println(UIMessage.ERROR_NUMBER_TYPE.getValue());
            throw new IllegalArgumentException(UIMessage.ERROR_NUMBER_TYPE.getValue());
        }
        return parsedBridgeSize;
    }
    private void vaildateBridgeSizeInclusive(Integer bridgeSize) {
        if (bridgeSize < BridgeLengthInclusive.START.getValue() || bridgeSize > BridgeLengthInclusive.END.getValue()) {
//            System.out.println(UIMessage.ERROR_BRIDGE_LENGTH_INCLUSIVE.getValue());
            throw new IllegalArgumentException(UIMessage.ERROR_BRIDGE_LENGTH_INCLUSIVE.getValue());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(UIMessage.REQUEST_INPUT_MOVE_CELL.getValue());
        String readMovingCapitalCharacter = readLine();
        if (!(readMovingCapitalCharacter.equals(BridgeGameRule.MOVE_UP.getValue())
                || readMovingCapitalCharacter.equals(BridgeGameRule.MOVE_DOWN.getValue()))) {
            throw new IllegalArgumentException(UIMessage.ERROR_INPUT_MOVE_CELL.getValue());
        }
        return readMovingCapitalCharacter;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(UIMessage.REQUEST_INPUT_RETRY_GAME.getValue());
        String readRetryCapitalCharacter = readLine();
        if (!(readRetryCapitalCharacter.equals(BridgeGameRule.RETRY.getValue())
                || readRetryCapitalCharacter.equals(BridgeGameRule.QUIT.getValue()))) {
            throw new IllegalArgumentException(UIMessage.ERROR_INPUT_RETRY_GAME.getValue());
        }
        return readRetryCapitalCharacter;
    }
}
