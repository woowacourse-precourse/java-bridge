package bridge.presentation.view;

import bridge.presentation.converter.Converter;
import bridge.presentation.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final static String READ_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";

    public int readBridgeSize() {
        System.out.println(READ_BRIDGE_SIZE);
        String bridgeSize = Console.readLine();
        InputValidator.validateBridgeSize(bridgeSize);
        return Converter.convertBridgeSize(bridgeSize);
    }

}
