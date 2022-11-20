package bridge.Model.VO;

import bridge.ChoiceResult;

import java.util.ArrayList;
import java.util.List;

public class ChoiceResults {
    List<String> choiceResults;

    public ChoiceResults(){
        this.choiceResults = new ArrayList<>();
    }

    public int index(){
        return choiceResults.size();
    }

    public void appendResult(ChoiceResult crossingResult) {

    }
}
