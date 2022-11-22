package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String REGEX = "^[0-9]*$";
    private static Constant constant = new Constant();
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            System.out.println(constant.Select_Size);
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(constant.Length_Restrict());
        }
    }
    
    public void checkLengthValidate(String input) {
        int length = Integer.parseInt(input);
        if(length < 3 || length > 20 || !input.matches(REGEX))
            throw new IllegalArgumentException(constant.Length_Restrict());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = Console.readLine();
        checkMoveValidate(move);        
        System.out.println(constant.Select_Move());
        System.out.println(move);
        return move;
    }

    public void checkMoveValidate(String input) {
        if(!(input.equals(constant.Up) || input.equals(constant.Down)))
            throw new IllegalArgumentException(constant.Move_Restrict());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(constant.Select_Retry);
        String cmd = Console.readLine();
        if (!(cmd.equals(constant.Restart) || cmd.equals(constant.Quit)))
            throw new IllegalArgumentException(constant.Replay_Restrict());
        return cmd;
    }
    
    public void checkRetryValidate(String input) {
        if(!(input.equals(constant.Restart) || input.equals(constant.Quit)))
            throw new IllegalArgumentException(constant.Replay_Restrict());
    }
}
