package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeSize =  Integer.parseInt(Console.readLine());
        if(bridgeSize > 3 || bridgeSize < 20)
            throw new IllegalArgumentException();
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = Console.readLine();
        if(!(move == "U" || move == "D"))
            throw new IllegalArgumentException();
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String Replay = Console.readLine();
        if(!(Replay == "R" || Replay == "Q"))  
            throw new IllegalArgumentException();
        return Replay;
    }
}
