package bridge;
import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */

public class InputView {

    InputView(){
        System.out.println(Constants.START_INFO);
        System.out.println();
    }

    public int readBridgeSize() {
        System.out.println(Constants.INPUT_LENGTH_INFO);
        /**
         * 다리의 길이를 입력받는다.
         */
        int bridgeLength = Integer.valueOf(Console.readLine());
        System.out.println(bridgeLength);
        return bridgeLength;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(Constants.INPUT_MOVING_INFO);
        String movingCommand = Console.readLine();
        return movingCommand;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(Constants.RESTART_INFO);
        String restartCommand = Console.readLine();
        return restartCommand;
    }
}
