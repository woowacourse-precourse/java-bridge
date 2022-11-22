package bridge;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REGEX = "^[0-9]*$";

    public static int readBridgeSize() {
        String bridgeSize = Console.readLine();
        int size = 0;
        boolean Try = true;
        System.out.println(Constant.INPUT_LENGTH);
        while(retry){
            try{
                size = Integer.parseInt(bridgeSize);
                retry = false;
            } catch(NumberFormatException e){
                throw new IllegalArgumentException(Constant.Length_Restrict());
            }
        }
        System.out.println(size);
        return size;
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
        if(!(input.equals(Constant.UP) || input.equals(Constant.DOWN)))
            throw new IllegalArgumentException(Constant.Move_Restrict());
    }

    public static String readGameCommand() {
        String replay = Console.readLine();
        checkRetryValidate(replay);
        System.out.println(Constant.Select_Replay());
        System.out.printf(replay);
        return replay;
    }

    public static void checkRetryValidate(String input) {
        if(!(input.equals(Constant.RESTART) || input.equals(Constant.QUIT)))
            throw new IllegalArgumentException(Constant.Replay_Restrict());
    }
}
