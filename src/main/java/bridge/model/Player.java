package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<String> choices = new ArrayList<>();

    public void add(String type){
        choices.add(type);
    }

    public List<String> getChoices() {
        return choices;
    }
}
