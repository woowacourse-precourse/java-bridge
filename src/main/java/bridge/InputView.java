package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        printStartInst();
        String bridgeLength = readLine();
        System.out.println();
        try {
            checkBridgeLength(bridgeLength);
            Integer.parseInt(bridgeLength);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            return readBridgeSize();
        }
        return Integer.parseInt(bridgeLength);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        printMoveInst();
        String upDown = readLine();
        try {
            checkUpOrDown(upDown);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] U 또는 D를 입력해야 합니다.");
            return readMoving();
        }
        return upDown;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        printRetryInst();
        String retryOrNot = readLine();
        try{
            checkRetryOrNot(retryOrNot);
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] R 또는 Q를 입력해야 합니다.");
            return readGameCommand();
        }
        return retryOrNot;
    }

    // UI logic for overall process
    private static void printStartInst() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    private static void printMoveInst() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    private static void printRetryInst() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String retryOrNot = readLine();
    }


    public static void checkBridgeLength(String bridgeLength) throws IllegalArgumentException {
        if (Integer.valueOf(bridgeLength)<3 || Integer.valueOf(bridgeLength)>20) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkUpOrDown(String upDown) throws IllegalArgumentException {
        if (!upDown.equals("U") && !upDown.equals("D")) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkRetryOrNot(String retryOrNot) throws IllegalArgumentException{
        if (!retryOrNot.equals("R") && !retryOrNot.equals("Q")) {
            throw new IllegalArgumentException();
        }
    }
}
