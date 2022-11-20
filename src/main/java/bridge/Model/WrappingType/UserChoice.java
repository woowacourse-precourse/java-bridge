package bridge.Model.WrappingType;

import bridge.Enum.Crossing;

public class UserChoice {
    private Crossing choice;

    public UserChoice(String choice) {
        this.choice = validData(choice);
    }

    private Crossing validData(String choice) {
        if (choice.equals(Crossing.DOWN.getString())) {
            return Crossing.DOWN;
        } else if (choice.equals(Crossing.UP.getString())) {
            return Crossing.UP;
        }
        throw new IllegalArgumentException("올바른 값을 입력해주세요");
    }

    public boolean compare(String other) {
        return choice.getString().equals(other);
    }

    public boolean compare(Crossing crossing) {
        return choice.equals(crossing);
    }
}
