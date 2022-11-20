package bridge.Model.VO;

import bridge.CrossResult;

import java.util.ArrayList;
import java.util.List;

public class ChoiceResults {
    List<CrossResult> crossResults;

    public ChoiceResults(){
        this.crossResults = new ArrayList<>();
    }

    public int index(){
        return crossResults.size();
    }

    public void appendResult(CrossResult crossResult) {
        crossResults.add(crossResult);
    }
}
