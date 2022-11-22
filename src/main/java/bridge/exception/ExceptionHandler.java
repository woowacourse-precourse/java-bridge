package bridge.exception;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ExceptionHandler {
    private static final String NUMBER_EXCEPTION_ERROR_MESSAGE = "[ERROR] 자연수의 숫자를 소수점 제외하여 입력해주세요.";
    private static final String NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 다리 길이의 범위는 3이상 20이하 입니다.";
    private static final String MOVING_CHARACTER_EXCEPTION_ERROR_MESSAGE = "[ERROR] U 또는 D만 입력할 수 있습니다.";
    private static final String GAME_COMMAND_CHARACTER_EXCEPTION_ERROR_MESSAGE = "[ERROR] R 또는 Q만 입력할 수 있습니다.";


    public static int sizeValidTest(String bridgeSize){
        while(true){
            try {
                bridgeSize = readLine();
                if (Integer.parseInt(bridgeSize) > 20 || Integer.parseInt(bridgeSize) < 3) throw new IllegalArgumentException();
                break;
            } catch (NumberFormatException e) { System.out.println(NUMBER_EXCEPTION_ERROR_MESSAGE);
            } catch (IllegalArgumentException e1) { System.out.println(NUMBER_RANGE_ERROR_MESSAGE);}
        }
        return Integer.parseInt(bridgeSize);
    }

    public static String movingValidTest(String moving){
        while(true){
            try{
                moving = readLine();
                if(moving.equals("U") || moving.equals("D")) break;
                throw new IllegalArgumentException();
            } catch(IllegalArgumentException e){System.out.println(MOVING_CHARACTER_EXCEPTION_ERROR_MESSAGE); }
        }
        return moving;
    }

    public static String gameCommandValidTest(String gameCommand){
        while(true){
            try{
                gameCommand = readLine();
                if(gameCommand.equals("R") || gameCommand.equals("Q")) break;
                throw new IllegalArgumentException();
            } catch(IllegalArgumentException e){System.out.println(GAME_COMMAND_CHARACTER_EXCEPTION_ERROR_MESSAGE); }
        }
        return gameCommand;
    }

}

