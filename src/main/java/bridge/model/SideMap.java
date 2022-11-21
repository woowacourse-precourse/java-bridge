package bridge.model;

import java.util.ArrayList;
import java.util.List;

public abstract class SideMap {

    protected static final String SUCCESS = "O";
    protected static final String FAIL = "X";
    protected static final String BLANK = " ";

    protected final List<String> sideMap = new ArrayList<>();

    public int size() {
        return sideMap.size();
    }

    public String get(int position) {
        return sideMap.get(position);
    }
}
