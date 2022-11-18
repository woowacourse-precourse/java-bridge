package bridge;

import java.util.List;

public class Bridge {
    private List<Command> answers;

    public Bridge(List<Command> answers) {
        this.answers = answers;
    }
}
