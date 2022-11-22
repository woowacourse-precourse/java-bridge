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
        if (userSelectResult.get(userSelectResult.size() - 1).equals("U") && success) {
            contentsMap.put("upContents", contentsMap.get("upContents") + "O");
            contentsMap.put("downContents", contentsMap.get("downContents") + " ");
        }//if
        if (userSelectResult.get(userSelectResult.size() - 1).equals("D") && success) {
            contentsMap.put("upContents", contentsMap.get("upContents") + " ");
            contentsMap.put("downContents", contentsMap.get("downContents") + "O");
        }//if
        if (userSelectResult.get(userSelectResult.size() - 1).equals("U") && !success) {
            contentsMap.put("upContents", contentsMap.get("upContents") + "X");
            contentsMap.put("downContents", contentsMap.get("downContents") + " ");
        }//if
        if (userSelectResult.get(userSelectResult.size() - 1).equals("D") && !success) {
            contentsMap.put("upContents", contentsMap.get("upContents") + " ");
            contentsMap.put("downContents", contentsMap.get("downContents") + "X");
        }//if
        return contentsMap;
    }//addLastMap


}// end class
