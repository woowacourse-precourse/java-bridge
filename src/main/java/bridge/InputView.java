package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REGEX = "^[0-9]*$";

    public static int readBridgeSize() {
        String bridgeSize = Console.readLine();
        int Size;
        try{
            Size = Integer.parseInt(bridgeSize);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException(Constant.Length_Restrict());
        }
        System.out.println(Constant.Start_Game);
        return Size;
    }

    public static void checkLengthValidate(String input) {
        int length = Integer.parseInt(input);
        if(length < 3 || length > 20 || !input.matches(REGEX))
            throw new IllegalArgumentException(Constant.Length_Restrict());
    }

    public static String readMoving() {
        String move = Console.readLine();
        checkMoveValidate(move);        
        System.out.println(Constant.Select_Move());
        System.out.println(move);
        return move;
    }

    public static void checkMoveValidate(String input) {
        if(!(input.equals(Constant.Up) || input.equals(Constant.Down)))
            throw new IllegalArgumentException(Constant.Move_Restrict());
    }

    public static String readGameCommand() {
        String Replay = Console.readLine();
        checkRetryValidate(Replay);
        System.out.println(Constant.Select_Replay());
        System.out.println(Replay);
        return Replay;
    }

    public static void checkRetryValidate(String input) {
        if(!(input.equals(Constant.Restart) || input.equals(Constant.Quit)))
            throw new IllegalArgumentException(Constant.Replay_Restrict());
    }
}
