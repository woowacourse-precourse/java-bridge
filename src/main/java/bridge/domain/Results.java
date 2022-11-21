package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Results {


    private final List<RoundResult> results;

    public Results(){
        this.results = new ArrayList<>();
    }

    public Results(List<RoundResult> results) {
        this.results = results;
    }

    public List<RoundResult> getResults() {
        return results;
    }

    public void addCurrentResult(RoundResult roundResult){
        this.results.add(roundResult);
    }
}
