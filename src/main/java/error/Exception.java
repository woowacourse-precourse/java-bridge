package error;

public class Exception {
    public static boolean input_error(String input){
        try {
            for (int i = 0; i < input.length(); i++) {
                if (!(input.charAt(i) >= '0' && input.charAt(i) <= '9'))
                    throw new IllegalArgumentException(ErrorMessage.BRIDGE_LENGTH_INPUT_ERROR.getErrormessage());
            }
            return false;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return true;
        }
    }
    public static boolean valid_number(String input){
        try {
            int size = Integer.parseInt(input);
            if (size < 3 || size > 20)
                throw new IllegalArgumentException(ErrorMessage.BRIDGE_LENGTH_ERROR.getErrormessage());
            return false;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return true;
        }
    }
    public static boolean valid_bridge(String move_location){
        try{
            if(move_location.length()!=1 || (!move_location.contains("U") && !move_location.contains("D")))
                throw new IllegalArgumentException(ErrorMessage.BRIDGE_SELECT_ERROR.getErrormessage());
            return false;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return true;
        }
    }
    public static boolean valid_restart(String re_game){
        try{
            if(re_game.length()!=1 || (!re_game.contains("R") && !re_game.contains("Q")))
                throw new IllegalArgumentException(ErrorMessage.RESTART_SELECT_ERROR.getErrormessage());
            return false;
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }
}
