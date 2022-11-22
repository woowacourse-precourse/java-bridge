package bridge.view;

import bridge.domain.Command;

public class ExceptionView {

    public static String message;

    public static void bridgeRangeError(){
        message = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    }

    public static void commandUpperOrLowerError(){
        String upperCommand = Command.UPPER.getCommand();
        String lowerCommand = Command.LOWER.getCommand();
        message = "[ERROR] " + upperCommand +"(위 칸)과 "+ lowerCommand +"(아래 칸) 중 하나를 선택하여야 합니다.";
    }

    public static void commandRestartOrNotError(){
        String restartCommand = Command.RESTART.getCommand();
        String quitCommand = Command.QUIT.getCommand();
        message = "[ERROR] " + restartCommand +"(재시작)과 " + quitCommand +"(종료) 중 하나를 선택하여야 합니다.";
    }



}
