package bridge.domain.user;

import java.util.ArrayList;
import java.util.List;

public class FootPrint {

    private static final String O = "O";
    private static final String X = "X";
    private static final String BLANK = " ";

    private final List<String> footPrint;

    public FootPrint() {
        this.footPrint = new ArrayList<>();
    }

    public void addBlank() {
        footPrint.add(BLANK);
    }

    public void addStep(int status) {
        if (status == User.ALIVE) {
            footPrint.add(O);
            return;
        }
        footPrint.add(X);
    }

    public void clear() {
        footPrint.clear();
    }

    @Override
    public String toString() {
        return String.format("[ %s ]%n", String.join(" | ", footPrint));
    }
}
