package bridge.presentation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReturnPrintMap {
    public Map<String, String> returnContentsMap(List<String> userSelectResult, boolean success) {
        Map<String, String> contentsMap = new HashMap<>();
        contentsMap.put("upContents", "");
        contentsMap.put("downContents", "");
        for (int index = 0; (index + 1) < userSelectResult.size(); index++) {
            contentsMap = lineChoice(userSelectResult, contentsMap, index);
        }//for
        contentsMap = addLastMap(userSelectResult, contentsMap, success);
        return contentsMap;
    }//returnContentsMap

    private Map<String, String> lineChoice(List<String> userSelectResult, Map<String, String> contentsMap, int index) {
        if (userSelectResult.get(index).equals("U")) {
            contentsMap.put("upContents", contentsMap.get("upContents") + "O | ");
            contentsMap.put("downContents", contentsMap.get("downContents") + "  | ");
            return contentsMap;
        }//if
        contentsMap.put("upContents", contentsMap.get("upContents") + "  | ");
        contentsMap.put("downContents", contentsMap.get("downContents") + "O | ");
        return contentsMap;
    }// lineChoice

    private Map<String, String> addLastMap(List<String> userSelectResult, Map<String, String> contentsMap, boolean success) {
        boolean isUpLine = userSelectResult.get(userSelectResult.size() - 1).equals("U");
        boolean isDownLine = userSelectResult.get(userSelectResult.size() - 1).equals("D");

        contentsMap = chooseUpLine(isUpLine, contentsMap, success);
        contentsMap = chooseDownLine(isDownLine, contentsMap, success);
        return contentsMap;
    }//addLastMap

    private Map<String, String> chooseUpLine(boolean isUpLine, Map<String, String> contentsMap, boolean success) {
        if (!isUpLine) {return contentsMap;}
        if (success) {contentsMap.put("upContents", contentsMap.get("upContents") + "O");}
        if (!success) {contentsMap.put("upContents", contentsMap.get("upContents") + "X");}
        contentsMap.put("downContents", contentsMap.get("downContents") + " ");
        return contentsMap;
    }//chooseUpLine

    private Map<String, String> chooseDownLine(boolean isDownLine, Map<String, String> contentsMap, boolean success) {
        if (!isDownLine) {return contentsMap;}
        contentsMap.put("upContents", contentsMap.get("upContents") + " ");
        if (success) {contentsMap.put("downContents", contentsMap.get("downContents") + "O");}
        if (!success) {contentsMap.put("downContents", contentsMap.get("downContents") + "X");}
        return contentsMap;
    }//chooseDownLine
}// end class
