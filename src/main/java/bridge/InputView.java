package bridge;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        int size = 0;
        OutputView.startPrint();
        while (size == 0) {
            OutputView.bridgeSizeInputPrint();
            String bridgeSize = Console.readLine();
            size = OutputView.validatorNonNumber(bridgeSize);
            size = OutputView.validatorNumberRange(size);
        } return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving(List<String> upBridge, List<String> downBridge) {
        OutputView.userSelect();
        String user = "";
        while (user.equals("")){
            user = Console.readLine();
            user = OutputView.validatorUserSelect(user);
        }
        return user;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        OutputView.retryPrint();
        String user = "";
        while (user.equals("")){
            user = Console.readLine();
            user = OutputView.validatorRetryUserSelect(user);
        }
        return user;
    }
}
