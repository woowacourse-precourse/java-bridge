package bridge.domain;

import bridge.view.OutputView;

import java.util.HashMap;

public enum BridgeShape {
    CORRECT(" O "),
    INCORRECT(" X "),
    BLANK("   "),
    SPLIT("|"),
    START("["),
    END("]");
    private final String type;
    BridgeShape(String type) {
        this.type = type;
    }

    public static void makeLines(MyBridge myBridge) {
        HashMap<String, String> bridgeMap = new HashMap<String, String>();
        bridgeMap.put("U", makeLine(myBridge,"U"));
        bridgeMap.put("D", makeLine(myBridge, "D"));
        OutputView.printMap(bridgeMap);
    }

    private static String makeLine(MyBridge myBridge, String target) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(START.type);
        for(int i=0; i<myBridge.getInputList().size(); i++) {
            boolean match = myBridge.compareBridgeBlock(i);
            stringBuilder.append(choiceBlock(match, myBridge.getInputList().get(i), target));
        }
        stringBuilder.setLength(stringBuilder.length()-1);
        stringBuilder.append(END.type);
        return stringBuilder.toString();
    }


    private static String choiceBlock(boolean match, String line, String target) {
        if (match && line.equals(target)) {
            return CORRECT.type + SPLIT.type;
        }
        if (!match && line.equals(target)) {
            return INCORRECT.type + SPLIT.type;
        }
        return BLANK.type + SPLIT.type;
    }

}
