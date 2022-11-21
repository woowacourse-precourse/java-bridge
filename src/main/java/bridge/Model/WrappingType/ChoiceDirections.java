package bridge.Model.WrappingType;

import java.util.ArrayList;
import java.util.List;

public class ChoiceDirections {
    private List<ChoiceDirection> ChoiceDirections;

    public ChoiceDirections(List<ChoiceDirection> choiceDirections) {
        this.ChoiceDirections = choiceDirections;
    }

    public void add(ChoiceDirection choiceDirection) {
        ChoiceDirections.add(choiceDirection);
    }

    public int length() {
        return ChoiceDirections.size();
    }

    public ChoiceDirection get(int position) {
        return ChoiceDirections.get(position);
    }
}
