package bridge.view;

import java.util.List;


public class OutputView {

    public void printMap(List<List<String>> result) {
        String upBridge = createBridgeMap(result.get(0));
        String downBridge = createBridgeMap(result.get(1));
        System.out.println(upBridge);
        System.out.println(downBridge);
    }

    private String createBridgeMap(List<String> map) {
        StringBuilder stringBuilder = new StringBuilder().append("[");
        for (String point : map) {
            stringBuilder.append(point).append("|");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.append("]").toString();
    }

}
