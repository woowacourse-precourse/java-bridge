package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class History {

    private final List<String> bridgeChars;

    public History() {
        this.bridgeChars = new ArrayList<>();
    }

    public History(List<String> bridgeChars){
        this.bridgeChars = bridgeChars;
    }

    public void appendMove(MoveCommand moveCommand) {
        bridgeChars.add(String.valueOf(moveCommand.getValue()));
    }

    public List<String> getBridgeChars() {
        return new ArrayList<>(bridgeChars);
    }
}
