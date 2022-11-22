package bridge.domain.user;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private final static String CORRECT_PATH = "O";
    private final static String WRONG_PATH = "X";
    private final static String EMPTY_PATH = " ";

    private final List<String> paths = new ArrayList<>();

    Path() {
    }

    public void addPath(boolean isCorrect) {
        if (isCorrect) {
            paths.add(Path.CORRECT_PATH);
            return;
        }

        paths.add(Path.WRONG_PATH);
    }

    public void addEmptyPath() {
        paths.add(Path.EMPTY_PATH);
    }

    public void clearPath() {
        paths.clear();
    }

    @Override
    public String toString() {
        return String.format("[ %s ]\n", String.join(" | ", paths));
    }
}
