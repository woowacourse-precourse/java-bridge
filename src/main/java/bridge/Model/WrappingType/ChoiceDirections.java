package bridge.Model.WrappingType;

import java.util.ArrayList;
import java.util.List;

public class ChoiceDirections {
    private final List<ChoiceDirection> ChoiceDirections;

    public ChoiceDirections(List<ChoiceDirection> choiceDirections) {
        this.ChoiceDirections = choiceDirections;
    }

    public static List<ChoiceDirection> of(List<String> elements){
        List<ChoiceDirection> choiceDirections = new ArrayList<>();
        for(String element : elements){
            choiceDirections.add(new ChoiceDirection(element));
        }

        return choiceDirections;
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
