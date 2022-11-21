package bridge.domain;

import bridge.view.OutputView;

import java.util.HashMap;

public class BridgeShape {
    private final static String CORRECT = " O ";
    private final static String INCORRECT = " X ";
    private final static String BLANK = "   ";
    private final static String SPLIT = "|";
    private final static String START = "[";
    private final static String END = "]";
    private static OutputView outputView = new OutputView();



    public static void makeLines(MyBridge myBridge) {
        HashMap<String, String> bridgeMap = new HashMap<String, String>();
        bridgeMap.put("U", makeLine(myBridge,"U"));
        bridgeMap.put("D", makeLine(myBridge, "D"));
        outputView.printMap(bridgeMap);
    }

    private static String makeLine(MyBridge myBridge, String target) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(START);
        for(int i=0; i<myBridge.getInputList().size(); i++) {
            boolean match = myBridge.compareBridgeBlock(i);
            stringBuilder.append(choiceBlock(match, myBridge.getInputList().get(i), target));
        }
        stringBuilder.setLength(stringBuilder.length()-1);
        stringBuilder.append(END);
        return stringBuilder.toString();
    }


    private static String choiceBlock(boolean match, String line, String target) {
        if (match && line.equals(target)) {
            return CORRECT + SPLIT;
        }
        if (!match && line.equals(target)) {
            return INCORRECT + SPLIT;
        }
        return BLANK + SPLIT;
    }

}
