package bridge.domain;

import java.util.List;

public class Bridge {
    private List<String> squares;

    public Bridge(List<String> squares) {
        validate();
        this.squares = squares;
    }

    private void validate() {}
}
