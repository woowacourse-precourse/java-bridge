package bridge;

import java.util.List;

public class Bridge {

    private final List<String> states;

    public Bridge(List<String> states) {
        this.states = states;
    }

    public boolean compareState(int length, String state) {
        String rightState = states.get(length - 1);

        if (rightState.equals(state)) {
            return true;
        }

        return false;
    }

    public void addState(String state) {
        states.add(state);
    }

    public void removeState() {
        int lastIndex = getSize() - 1;
        states.remove(lastIndex);
    }

    private String getLastState() {
        int lastIndex = getSize() - 1;
        return states.get(lastIndex);
    }

    private int getSize() {
        return states.size();
    }
}
