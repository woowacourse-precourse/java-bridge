package bridge.domain;

import bridge.vo.Direction;

import java.util.ArrayList;
import java.util.List;

public class BridgePrinter {
    private static final String START = "[";
    private static final String BORDER = "|";
    private static final String END = "]";
    private static final String CORRECT = " O ";
    private static final String WRONG = " X ";
    private static final String BLANK = "   ";

    User user;
    Bridge bridge;

    public void print(User user, Bridge bridge) {
        this.user = user;
        this.bridge = bridge;
        printLine(Direction.UP);
        printLine(Direction.DOWN);
    }

    public void printLine(String direction) {
        StringBuilder sb = new StringBuilder();
        sb.append(START);
        for (String s : makeBridgeLine(direction)) {
            sb.append(s).append(BORDER);
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(END);
        System.out.println(sb.toString());
    }

    public List<String> makeBridgeLine(String direction) {
        List<String> bridgeLine = new ArrayList<>();
        for (int i = 0; i < user.getUserMovings().size(); i++) {
            makeBridgeLine(bridgeLine, direction, i);
        }
        return bridgeLine;
    }

    private void makeBridgeLine(List<String> upBridge, String direct, int i) {
        if (!user.getUserMovings().get(i).equals(direct)) {
            upBridge.add(BLANK);
            return;
        }
        if (user.getUserMovings().get(i).equals(bridge.getAnswerBridge().get(i)))
            upBridge.add(CORRECT);
        if (!user.getUserMovings().get(i).equals(bridge.getAnswerBridge().get(i)))
            upBridge.add(WRONG);
    }

}
