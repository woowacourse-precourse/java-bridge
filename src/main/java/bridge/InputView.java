package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static Constant constant = new Constant();
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeSize =  Integer.parseInt(Console.readLine());
        if(bridgeSize > 3 || bridgeSize < 20)
            throw new IllegalArgumentException(constant.Length_Restrict());
        System.out.println(constant.Game_Start());
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = Console.readLine();
        if(!(move == "U" || move == "D"))
            throw new IllegalArgumentException(constant.Move_Restrict());
        System.out.println(constant.Select_Move());
        System.out.println(move);
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String Replay = Console.readLine();
        if(!(Replay == "R" || Replay == "Q"))  
            throw new IllegalArgumentException(constant.Replay_Restrict());
        System.out.println(constant.Select_Replay());
        System.out.println(Replay);
        return Replay;
    }
}
