package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */

    public int readBridgeSize() {
        try {
            String temp = camp.nextstep.edu.missionutils.Console.readLine();
            System.out.println((int) temp.charAt(0));
            if (48 > temp.charAt(0) || 57 < temp.charAt(0)) throw new IllegalArgumentException("[ERROR]");
            int i = Integer.parseInt(temp);
            return i;

        } catch (IllegalArgumentException E) {
            System.out.println("[ERROR] PLEASE INPUT INT NUMBER");
        }
        return 0;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            String temp = camp.nextstep.edu.missionutils.Console.readLine();
            if ( "D"!=temp|| temp!="U") throw new IllegalArgumentException("[ERROR]");
            return temp;

        } catch (IllegalArgumentException E) {
            System.out.println("[ERROR] PLEASE INPUT U OR D");
        }
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            String temp = camp.nextstep.edu.missionutils.Console.readLine();
            if ( "R"!=temp|| temp!="Q") throw new IllegalArgumentException("[ERROR]");
            return temp;

        } catch (IllegalArgumentException E) {
            System.out.println("[ERROR] PLEASE INPUT R OR Q");
        }
        return null;
    }
}
