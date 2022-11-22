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
        try {
            System.out.println("다리의 길이를 입력해주세요.");
            String inputSize = Console.readLine();
            return convertInputSize(inputSize);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return readBridgeSize();
        }
    }

    private int convertInputSize(String inputSize) {
        int size = Integer.parseInt(inputSize);
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("다리길이는 3이상 20이하여야 합니다");
        }
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String inputMoving = Console.readLine();
            return getValidatedInputMoving(inputMoving);
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR] " + e.getMessage());
            return readMoving();
        }
    }

    private String getValidatedInputMoving(String inputMoving) {
        if (!"U".equals(inputMoving) && !"D".equals(inputMoving)) {
            throw new IllegalArgumentException("U또는 D를 선택해야 합니다.");
        }
        return inputMoving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try{
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String inputCommand = Console.readLine();
            return getValidatedInputCommand(inputCommand);
        } catch (IllegalArgumentException e){
            System.out.println("[ERROR] " + e.getMessage());
            return readMoving();
        }
    }

    private String getValidatedInputCommand(String inputCommand){
        if (!"R".equals(inputCommand) && !"Q".equals(inputCommand)){
            throw new IllegalArgumentException("R또는 Q를 선택해야 합니다.");
        }
        return inputCommand;
    }
}
