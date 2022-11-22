package bridge.Model.WrappingType;

import java.util.ArrayList;
import java.util.List;

public class ChoiceDirections {
    private final List<ChoiceDirection> choiceDirections;

    public ChoiceDirections(List<ChoiceDirection> choiceDirections) {
        this.choiceDirections = choiceDirections;
    }

    public static List<ChoiceDirection> of(List<String> elements) {
        List<ChoiceDirection> choiceDirections = new ArrayList<>();
        for (String element : elements) {
            choiceDirections.add(new ChoiceDirection(element));
        }

        return choiceDirections;
    }

    public void add(ChoiceDirection choiceDirection) {
        choiceDirections.add(choiceDirection);
    }

    public int length() {
        return choiceDirections.size();
    }

    public ChoiceDirection get(int position) {
        return choiceDirections.get(position);
    }
}
