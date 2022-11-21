package bridge;

import static bridge.OutputMsg.*;
import static bridge.Validator.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.awt.desktop.SystemEventListener;
import java.io.Console;
import javax.swing.plaf.synth.SynthTextAreaUI;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */

public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_LENGTH_MSG.getMsg());
        String bridgeLength = readLine();
        validateBridgeLength(bridgeLength);
        return Integer.parseInt(bridgeLength);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public char readMoving() {
        System.out.println(CHOOSE_UPDOWN_MSG.getMsg());
        String bridgeMoving = readLine();
        validateMoving(bridgeMoving);
        return  bridgeMoving.charAt(0);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public char readGameCommand() {
        System.out.println(CHOOSE_RETRY_QUIT_MSG.getMsg());
        String gameCheck = readLine();
        validateGameCheck(gameCheck);
        return gameCheck.charAt(0);
    }
}
