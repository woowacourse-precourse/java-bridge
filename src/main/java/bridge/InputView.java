package bridge;

import static bridge.Util.toInt;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        return readLine();
    }


}
