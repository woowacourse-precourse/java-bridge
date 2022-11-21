package bridge;

public class Exception {
    public static int input_error(String input){
        for(int i=0;i<input.length();i++){
            if(!(input.charAt(i)>='0' && input.charAt(i)<='9'))
                throw new IllegalArgumentException(ErrorMessage.BRIDGE_LENGTH_INPUT_ERROR.getErrormessage());
        }
        return Integer.parseInt(input);
    }
    public static void valid_number(int size){
        if(size<3||size>20)
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_LENGTH_ERROR.getErrormessage());
    }
    public static void valid_bridge(String move_location){
        if(move_location.length()!=1 || (!move_location.contains("U") && !move_location.contains("D")))
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SELECT_ERROR.getErrormessage());
    }
    public static void valid_restart(String re_game){
        if(re_game.length()!=1 || (!re_game.contains("R") && !re_game.contains("Q")))
            throw new IllegalArgumentException(ErrorMessage.RESTART_SELECT_ERROR.getErrormessage());
    }
}
