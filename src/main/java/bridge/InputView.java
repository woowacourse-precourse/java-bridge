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
        // should check error here
        return Integer.parseInt(bridgeLength);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        printMoveInst();

        String upDown = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.println();
        // should check error here
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
    private static void printStartInst(){
        System.out.println("다리의 길이를 입력해주세요.");
    }

    private static void printMoveInst(){
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    private static void printRetryInst(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
