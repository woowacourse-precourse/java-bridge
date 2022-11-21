package bridge.view.draw;

import bridge.domain.MovingCommand;
import java.util.ArrayList;
import java.util.List;

public abstract class BridgeDrawer {

    private final List<String> first = new ArrayList<>();
    private final List<String> second = new ArrayList<>();

    public String draw() {
        makeBridgeFormat();
        String firstLine = convertLineToString(this.first);
        String secondLine = convertLineToString(this.second);
        return firstLine + Pattern.ENTER + secondLine;
    }

    protected abstract void makeBridgeFormat();

    protected void addWordIfMatches(String command, MovingCommand movingCommand, String upWord, String downWord) {
        validateCommand(command);
        if (command.equals(movingCommand.getName())) {
            this.first.add(upWord);
            this.second.add(downWord);
        }
    }

    private void validateCommand(String command) {
        MovingCommand.nameOf(command);
    }

    private String convertLineToString(List<String> line) {
        return line.toString()
                .replaceAll(Pattern.COMMA + Pattern.SPACE, Pattern.SPACE + Pattern.BAR + Pattern.SPACE)
                .replaceAll(Pattern.OPEN_BRACKET, Pattern.OPEN_BRACKET + Pattern.SPACE)
                .replaceAll(Pattern.CLOSE_BRACKET, Pattern.SPACE + Pattern.CLOSE_BRACKET);
    }

    private static class Pattern {
        private static final String COMMA = ",";
        private static final String SPACE = " ";
        private static final String OPEN_BRACKET = "\\[";
        private static final String CLOSE_BRACKET = "]";
        private static final String BAR = "|";
        private static final String ENTER = "\n";
    }
}
