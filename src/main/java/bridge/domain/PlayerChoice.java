package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import bridge.constant.Direction;

/**
 * 플레이어의 선택을 관리하는 클래스
 */
public class PlayerChoice {
    List<Direction> choices;

    public PlayerChoice() {
        choices = new ArrayList<Direction>();
    }

    public void add(Direction direction) {
        choices.add(direction);
    }

    public void clear() {
        choices.clear();
    }

    public boolean isValid(List<String> bridgeAnswer) {
        for (int index = 0; index < choices.size(); index++) {
            Direction choice = choices.get(index);
            Direction answer = Direction.getDirection(bridgeAnswer.get(index));

            if (!choice.equals(answer)) {
                return false;
            }
        }

        return true;
    }

    public boolean isArrived(List<String> bridgeAnswer) {
        int lastIndex = bridgeAnswer.size() - 1;
        Direction lastAnswer = Direction.getDirection(bridgeAnswer.get(lastIndex));

        if (choices.size() == bridgeAnswer.size() && choices.get(lastIndex) == lastAnswer) {
            return true;
        }

        return false;
    }
}