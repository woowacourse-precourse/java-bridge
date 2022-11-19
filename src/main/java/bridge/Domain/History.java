package bridge.Domain;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<String> choices;
    private boolean success;
    private int tries;

    public History() {
        this.choices = new ArrayList<>();
        this.success = false;
        this.tries = 0;
    }

    @Override public String toString() {
        StringBuilder result = new StringBuilder();

        for (String space : choices) {
            result.append(space);
        }
        return result.toString();
    }

    public void move(String moveTo) {
        choices.add(moveTo);
    }

    public String getSpaceByLocation(int location) {
        return choices.get(location);
    }

    public void gameSuccess() {
        success = true;
    }

    public boolean isSuccess() {
        return success;
    }

    public void gameTry() {
        tries += 1;
    }

    public int getTries() {
        return tries;
    }

    public void reset() {
        choices = new ArrayList<>();
    }
}
