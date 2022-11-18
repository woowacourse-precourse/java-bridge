package bridge.Domain;

import java.util.ArrayList;
import java.util.List;

public class History {
    private final List<String> choices;
    private final boolean success;
    private final int tries;

    public History() {
        this.choices = new ArrayList<>();
        this.success = false;
        this.tries = 0;
    }
}
