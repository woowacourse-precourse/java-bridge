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
            System.out.println((int)temp.charAt(0));
            if(48>temp.charAt(0) || 57<temp.charAt(0))throw  new IllegalArgumentException("[ERROR]");
            int i=Integer.parseInt(temp);
            return i;

        }catch (IllegalArgumentException E){
            System.out.println("[ERROR]");
        }
        return 0;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return camp.nextstep.edu.missionutils.Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return camp.nextstep.edu.missionutils.Console.readLine();
    }
}
