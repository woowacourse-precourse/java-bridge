package view;

import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    StringBuilder sb;

    /**
     * 다리의 길이를 입력받는다.
     */
    static public int readBridgeSize() {
        System.out.println(ViewMessage.ASK_BRIDGE_LONG);
        int size = readInt();
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        while (true) {
            try {
                System.out.println(ViewMessage.ASK_MOVE_BRIDGE);
                String s = vaildUD();
                return  s;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(ViewMessage.ASK_RETRY);
        String s = readLine();
        // 예외처리 : 지정된 문자열이 아닐 때
        return s;
    }

    static private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(readLine());
            } catch (NumberFormatException e) {
                e.getStackTrace();
                System.out.println("숫자가 아닙니다. 다시 입력하세요.");
            }
        }
    }

    static private String vaildUD() {
        String move = readLine();
        if (!move.equals("U") && !move.equals("D")) {
            throw new IllegalArgumentException("[ERROR]");
        }
        return move;
    }

}
