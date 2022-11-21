package bridge.domain;

import bridge.vo.Command;

import java.util.ArrayList;
import java.util.List;

public class BridgePrinter {
    private static final String START = "[";
    private static final String BORDER = "|";
    private static final String END = "]";

    User user;
    Bridge bridge;

    public void printLine(User user, Bridge bridge) {
        this.user = user;
        this.bridge = bridge;
        bridgeLine(Command.UP);
        bridgeLine(Command.DOWN);
    }

    public void bridgeLine(String direction) {
        StringBuilder sb = new StringBuilder();
        sb.append(START);
        for (String s : makeBridgeLine(direction)) {
            sb.append(s).append(BORDER);
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(END);
        System.out.println(sb.toString());
    }

    public List<String> makeBridgeLine(String direction) {
        List<String> bridgeLine = new ArrayList<>();
        for (int i = 0; i < user.getUserMovings().size(); i++) {
            compareBridgeLine(bridgeLine, direction, i);
        }
        return bridgeLine;
    }

    private void compareBridgeLine(List<String> bridgeLine, String direct, int i) {
        if (!user.getUserMovings().get(i).equals(direct)) {
            bridgeLine.add(Command.BLANK);
            return;
        }
        if (user.getUserMovings().get(i).equals(bridge.getAnswerBridge().get(i)))
            bridgeLine.add(Command.CORRECT);
        if (!user.getUserMovings().get(i).equals(bridge.getAnswerBridge().get(i)))
            bridgeLine.add(Command.WRONG);
    }

}
