package error;

import camp.nextstep.edu.missionutils.Console;

public class Exception {
    public static int input_error(String input){
        try {
            for (int i = 0; i < input.length(); i++) {
                if (!(input.charAt(i) >= '0' && input.charAt(i) <= '9'))
                    throw new IllegalArgumentException(ErrorMessage.BRIDGE_LENGTH_INPUT_ERROR.getErrormessage());
            }
            return Integer.parseInt(input);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            input = Console.readLine();
            return input_error(input);
        }
    }
    public static int valid_number(int size){
        try {
            if (size < 3 || size > 20)
                throw new IllegalArgumentException(ErrorMessage.BRIDGE_LENGTH_ERROR.getErrormessage());
            return size;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            String input = Console.readLine();
            return valid_number(input_error(input));
        }
    }
    public static String valid_bridge(String move_location){
        try{
            if(move_location.length()!=1 || (!move_location.contains("U") && !move_location.contains("D")))
                throw new IllegalArgumentException(ErrorMessage.BRIDGE_SELECT_ERROR.getErrormessage());
            return move_location;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            move_location = Console.readLine();
            return valid_bridge(move_location);
        }
    }
    public static String valid_restart(String re_game){
        try{
            if(re_game.length()!=1 || (!re_game.contains("R") && !re_game.contains("Q")))
                throw new IllegalArgumentException(ErrorMessage.RESTART_SELECT_ERROR.getErrormessage());
            return re_game;
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            re_game = Console.readLine();
            return valid_restart(re_game);
        }
    }
}
