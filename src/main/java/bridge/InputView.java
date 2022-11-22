package bridge;
import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(StringEnum.INPUT_BRIDGE_SIZE.getStr());
        String inputBridgeSize = Console.readLine();
        validateBridgeSize(inputBridgeSize);
        return Integer.valueOf(inputBridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(StringEnum.INPUT_MOVIECHOICE.getStr());
        String inputMoving = Console.readLine();
        validateMove(inputMoving);
        return inputMoving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(StringEnum.INPUT_RETRYORQUITE.getStr());
        String inputGameCommand = Console.readLine();
        return inputGameCommand;
    }

    private void validateMove(String inputMoving) throws IllegalArgumentException{
        if(inputMoving.replaceAll("[^UD]","").length() != inputMoving.length()){
            throw new IllegalArgumentException("이동할 칸은 U 혹은 D로 입력합니다.");
        }
    }

    private void validateBridgeSize(String inputBridgeSize) throws IllegalArgumentException{
        int stringToint = Integer.valueOf(inputBridgeSize);
        if(!inputBridgeSize.equals(inputBridgeSize.replaceAll("[^0-9]", ""))) {
            throw new IllegalArgumentException("다리 길이는 숫자만 입력가능합니다.");
        }
        if (stringToint < 3 || stringToint > 20) {
            throw new IllegalArgumentException("다리 길이는 3이상 20이하의 자연수 입니다.");
        }
    }
    private void validateRetry(String inputMoving) throws IllegalArgumentException{
        if(inputMoving.replaceAll("[^QR]","").length() != inputMoving.length()){
            throw new IllegalArgumentException("이동할 칸은 Q 혹은 R로 입력합니다.");
        }
    }
}