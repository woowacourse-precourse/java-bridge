package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String bridgesSize = readLine();
        notNumber(bridgesSize);
        validateBridgeSize(Integer.valueOf(bridgesSize));
        return Integer.valueOf(bridgesSize);
    }
    private void notNumber(String bridgesSize){
        try {
            checkNumber(bridgesSize);
        }catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 숫자만 입력해 주세요.");
            readBridgeSize();
        }
    }

    private void checkNumber(String bridgesSize) {
        bridgesSize=bridgesSize.replaceAll("[0-9]", "");
        if (bridgesSize != "") {
            throw new IllegalArgumentException();
        }
    }

    private void validateBridgeSize(int numbers) {
        try {
            checkBridgeSize(numbers);
        }catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 다리 길이를 3이상 20이하로 입력 하세요.");
            readBridgeSize();
        }
    }

    private void checkBridgeSize(int numbers) {
        if (numbers<3 || numbers>20) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moveBridgePosition = readLine();
        return moveBridgePosition;
    }

    private void validateMoving(String moveBridgePosition){
        try {
            checkMoving(moveBridgePosition);
        }catch (IllegalArgumentException e) {
            System.out.println("[ERROR] ");
            readMoving();
        }
    }

    private void checkMoving(String moveBridgePosition) {
        if (moveBridgePosition != "U" && moveBridgePosition != "D") {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String retryQuit = readLine();
        return retryQuit;
    }

    private void validateGameCommand(String retryQuit){
        try {
            checkGameCommand(retryQuit);
        }catch (IllegalArgumentException e) {
            System.out.println("[ERROR] ");
            readGameCommand();
        }
    }

    private void checkGameCommand(String retryQuit) {
        if (retryQuit != "R" && retryQuit != "Q") {
            throw new IllegalArgumentException();
        }
    }
}
