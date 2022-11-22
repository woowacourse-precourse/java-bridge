package bridge.domain;

public class MapPrinter {
    private static final char END = ']';
    private static final String CORRECT = " O |";
    private static final String WRONG = " X |";
    private static final String BLANK = "   |";
    private static final String NEXT_LINE = "\n";
    private StringBuilder up = new StringBuilder("[");
    private StringBuilder down = new StringBuilder("[");

    public void move(Position position, boolean correct) {
        if (position == Position.UP) {
            addBridge(up, correct);
            addBlank(down);
            return;
        }

        addBridge(down, correct);
        addBlank(up);
    }

    private void addBridge(StringBuilder line, boolean correct) {
        if (correct) {
            line.append(CORRECT);
            return;
        }
        line.append(WRONG);
    }

    private void addBlank(StringBuilder line) {
        line.append(BLANK);
    }

    public String printMap() {
        StringBuilder first = new StringBuilder(up);
        StringBuilder second = new StringBuilder(down);
        first.setCharAt(first.length() - 1, END);
        second.setCharAt(second.length() - 1, END);
        return first + NEXT_LINE + second;
    }

    public void init() {
        up = new StringBuilder("[");
        down = new StringBuilder("[");
    }
}
