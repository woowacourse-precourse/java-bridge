package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Branch {
    private final List<Integer> branch;

    public Branch() {
        branch = new ArrayList<>();
    }

    public void set(int index, int canMove) {
        makeIndex(index);
        branch.set(index, canMove);
    }

    public void reset(int index) {
        branch.set(index, Move.NONE.getNumber());
    }

    public void makeIndex(int index) {
        while (branch.size() != (index + 1)) {
            branch.add(0);
        }
    }

    public String getString() {
        return branch.stream()
                .map(Move::convertToString)
                .collect(Collectors.joining(" | "));
    }
}
