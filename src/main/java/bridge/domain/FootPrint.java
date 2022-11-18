package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class FootPrint {

    private final List<String> footPrint;

    public FootPrint() {
        this.footPrint = new ArrayList<>();
    }

    public void add(String step) {
        footPrint.add(step);
    }

    public void clear() {
        footPrint.clear();
    }

    @Override
    public String toString() {
        return String.format("[ %s ]\n", String.join(" | ", footPrint));
    }
}
