package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REGEX = "^[0-9]*$";
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        int Size;
        try{
            Size = Integer.parseInt(bridgeSize);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException(Constant.Length_Restrict());
        }
        System.out.println(Constant.Game_Start());
        return Size;
    }

    public void checkLengthValidate(String input) {
        int length = Integer.parseInt(input);
        if(length < 3 || length > 20 || !input.matches(REGEX))
            throw new IllegalArgumentException(Constant.Length_Restrict());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = Console.readLine();
        checkMoveValidate(move);        
        System.out.println(Constant.Select_Move());
        System.out.println(move);
        return move;
    }

    public void checkMoveValidate(String input) {
        if(!(input.equals(Constant.Up) || input.equals(Constant.Down)))
            throw new IllegalArgumentException(Constant.Move_Restrict());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String Replay = Console.readLine();
        checkRetryValidate(Replay);
        System.out.println(Constant.Select_Replay());
        System.out.println(Replay);
        return Replay;
    }

    public void checkRetryValidate(String input) {
        if(!(input.equals(Constant.Restart) || input.equals(Constant.Quit)))
            throw new IllegalArgumentException(Constant.Replay_Restrict());
    }
}
