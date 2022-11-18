package bridge;

import java.util.Scanner;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    static Scanner sc = new Scanner(System.in);
    static int bridgeSize;
    static String movingPoint;
    static String exitPoint;
    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        try{
            System.out.println("다리의 길이를 입력해주세요.");
            bridgeSize = sc.nextInt();
            if(bridgeSize < 3 || bridgeSize > 20)
                throw new IllegalArgumentException();
        }
        catch(IllegalArgumentException e){
            System.out.println("[ERROR] 잘못된 다리 길이 입력");
            readBridgeSize();
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        try {
            System.out.println("이동할 칸을 선택해주세요. (위 : U, 아래 : D)");
            movingPoint = sc.next();
            if (!(movingPoint.equals("U") || movingPoint.equals("D")))
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 잘못된 이동할 칸 선택");
            readMoving();
        }
        return movingPoint;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        try {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도 : R, 종료 : Q)");
            exitPoint = sc.next();
            if (!(exitPoint.equals("R") || exitPoint.equals("Q")))
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 잘못된 여부 선택");
            readGameCommand();
        }
        return exitPoint;
    }
}
