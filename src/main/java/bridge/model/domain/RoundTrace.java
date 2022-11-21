package bridge.model.domain;

import bridge.model.validation.Move;

import java.util.Arrays;
import java.util.List;

public enum RoundTrace {
    ROUND_CLEAR(" O |"),
    ROUND_FAIL(" X |"),
    BLANK("   |");

    private final String footPrint;

    RoundTrace(String footPrint) {
        this.footPrint = footPrint;
    }

    public String getFootPrint() {
        return footPrint;
    }

    private static List<String> makeTrace(int randomValue, boolean isCorrect){
        String trace = isClearRound(isCorrect);
        return convertToList(randomValue, trace);
    }

    public static String isClearRound(boolean isCorrect){
        if(isCorrect){
            return ROUND_CLEAR.footPrint;
        }
        return ROUND_FAIL.footPrint;
    }

    private static List<String> convertToList(int randomValue, String trace){
        if(randomValue == 1){
            return Arrays.asList(trace, BLANK.footPrint);
        }
        return Arrays.asList(BLANK.footPrint, trace);
    }


}
