package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        printStartInst();
        String bridgeLength = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.println();
        try {
            checkBridgeLength(bridgeLength);
            Integer numberLength = Integer.parseInt(bridgeLength);

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] should input bridge length as integer");
            readBridgeSize();
        }
        return Integer.parseInt(bridgeLength);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        printMoveInst();
        String upDown = camp.nextstep.edu.missionutils.Console.readLine();
        try {
            checkUpOrDown(upDown);
            return upDown;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] should input U or D");
            readMoving();
        }
        return upDown;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        printRetryInst();
        String retryOrNot = camp.nextstep.edu.missionutils.Console.readLine();
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
}
