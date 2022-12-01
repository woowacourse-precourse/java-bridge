package bridge.model;

import java.util.List;

public class BridgeGame {

    public void move(final Player player, final String choice) {
        player.addChoice(choice);
    }

    public void retry(final Player player) {
        player.resetChoices();
        player.addTryCount();
    }

    public boolean isCorrectChoice(final List<String> bridge, final List<String> choices, final int index) {
        String answer = bridge.get(index);
        String choice = choices.get(index);
        return answer.equals(choice);
    }

    public boolean isApproachLast(final int bridgeSize, final int choicesSize) {
        return bridgeSize == choicesSize;
    }

}