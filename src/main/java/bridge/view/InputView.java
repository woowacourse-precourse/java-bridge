package bridge.view;
import bridge.constant.Constant;
import bridge.constant.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String readBridgeSize = "다리의 길이를 입력해주세요.";
    private static final String readMoving = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String readGameCommand = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(readBridgeSize);
        String inputBridgeSize = Console.readLine();
        try {
            return bridgeSize(inputBridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    private int bridgeSize(String inputBridgeSize) {
        try {
            int bridgeSize = Integer.parseInt(inputBridgeSize);
            if (bridgeSize < Constant.MIN_LENGTH || bridgeSize > Constant.MAX_LENGTH) {
                throw new IllegalArgumentException(ErrorMessage.bridgeSizeError.getErrorMessage());
            }
            return bridgeSize;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.bridgeSizeError.getErrorMessage());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(readMoving);
        String inputMoving = Console.readLine();
        try {
            return BridgeBlock.getBlockName(inputMoving);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() {
        System.out.println(readGameCommand);
        String inputGameCommand = Console.readLine();
        try {
            return GameCommand.willRestart(inputGameCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }
}
