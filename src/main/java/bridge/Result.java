package bridge;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private List<Boolean> result = new ArrayList<>();

    public void update(Boolean guessResult){
        result.add(guessResult);
    }

    public int size(){
        return result.size();
    }
}
