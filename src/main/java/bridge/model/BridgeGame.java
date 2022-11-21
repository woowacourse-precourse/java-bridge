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

    public boolean isCorrectChoice(List<String> bridge, List<String> choices, int index) {
        String answer = bridge.get(index);
        String choice = choices.get(index);
        return answer.equals(choice);
    }

    public boolean isApproachLast(int bridgeSize, int choicesSize) {
        return bridgeSize == choicesSize;
    }

}