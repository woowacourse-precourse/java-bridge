package bridge.Model.VO;

import bridge.CrossResult;

import java.util.ArrayList;
import java.util.List;

public class ChoiceResults {
    List<CrossResult> crossResults;

    public ChoiceResults(){
        this.crossResults = new ArrayList<>();
    }

    public int position(){
        return crossResults.size();
    }

    public void appendResult(CrossResult crossResult) {
        crossResults.add(crossResult);
    }

    public boolean contain(CrossResult crossResult){
        return crossResults.contains(crossResult);
    }
}
