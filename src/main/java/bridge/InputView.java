package bridge;
import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String tmp = Console.readLine();
        try {
            int res = Integer.parseInt(tmp);
            return res;
        }catch(Exception e){
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String tmp = Console.readLine();
        if(tmp.length() != 1) throw new IllegalArgumentException();
        if(!(tmp.charAt(0) == 'U' || tmp.charAt(0) == 'D')) throw new IllegalArgumentException();
        return tmp;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String tmp = Console.readLine();
        if(tmp.length() != 1) throw new IllegalArgumentException();
        if(!(tmp.charAt(0) == 'R' || tmp.charAt(0) == 'Q')) throw new IllegalArgumentException();
        return tmp;
    }
}
