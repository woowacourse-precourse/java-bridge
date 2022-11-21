package bridge.view;

import bridge.view.constant.InputGuidePhrase;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(InputGuidePhrase.BRIDGE_LENGTH.get());
        String bridgeLength = Console.readLine().trim();
        ViewValidator.validateNumberInput(bridgeLength);
        return Integer.parseInt(bridgeLength);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(InputGuidePhrase.PANEL.get());
        String panelInput = Console.readLine().trim();
        ViewValidator.validatePanelInput(panelInput);
        return panelInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(InputGuidePhrase.RETRY.get());
        String retryOptionInput = Console.readLine().trim();
        return null;
    }
}
