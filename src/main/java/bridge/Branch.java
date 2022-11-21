package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Branch {
    private final List<Integer> branch;

    public Branch() {
        branch = new ArrayList<>();
    }

    public void set(int index, int bool) {
        makeIndex(index);
        branch.set(index, bool);
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
