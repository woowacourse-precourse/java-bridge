package bridge.rule;

import bridge.domain.Bridge;

public class EndRule {

    public static boolean isQuit(String command){
        return command.equals("Q");
    }

    public static String isComplete(Bridge bridge){
        if (bridge.isLastStep()){
            return "성공";
        }
        return "실패";
    }

}
