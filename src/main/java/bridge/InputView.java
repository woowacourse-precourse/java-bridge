package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private Exeption exeption = new Exeption();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        boolean isOK = false;
        String size = "";
        while (!isOK) {
            size = inputBridgeSize();
            if (!exeption.inputBridgeSizeCheck(size)) {
                continue;
            }
            isOK = true;
        }
        return Integer.parseInt(size);
    }
    public String inputBridgeSize(){
        System.out.println("\n다리의 길이를 입력해주세요.");
        String size = Console.readLine();
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        boolean isOK = false;
        String input = "";
        while(!isOK) {
            input = inputMoving();
            if(!exeption.inputUserMovingCheck(input)) {
                continue;
            }
            isOK = true;
        }
        return input;
    }
    public String inputMoving(){
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        return input;
    }
}
