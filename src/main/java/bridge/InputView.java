package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            System.out.println("다리의 길이를 입력해주세요.");
            String Input = Console.readLine();
            System.out.println("");
            Integer BridgeSize = Integer.valueOf(Input);
            if (BridgeSize > 20 || BridgeSize < 3) {
                throw new IllegalArgumentException();
            }
            return BridgeSize;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 다리길이는 3이상 20이하의 숫자만 입력 가능합니다.");
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
