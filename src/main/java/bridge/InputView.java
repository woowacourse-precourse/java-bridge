package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    ValidationInput validationInput = new ValidationInput();
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String sizeOfBridge =  camp.nextstep.edu.missionutils.Console.readLine();
        int size = Integer.parseInt(sizeOfBridge);
        return size;
    }

    public String valid_sizeOfBridge(String size){
        validationInput.checkDigit(size);
        validationInput.validSizeOfBridge(size);
        return size;
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
