package bridge;


import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println("다리 길이를 입력해 주세요.");
        String bridgeSize = Console.readLine();
        try{
            Validate.isInputBridgeSizeValid(bridgeSize);
            return Integer.parseInt(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        while(true) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String upOrDown = Console.readLine();
            try{
                Validate.isUOrD(upOrDown);
                return upOrDown.toUpperCase();
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String readRetry() {
        while(true) {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String retryOrQuit = Console.readLine();
            try{
                Validate.isROrQ(retryOrQuit);
                return retryOrQuit.toUpperCase();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
