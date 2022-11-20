package bridge.domain;

import bridge.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<List<String>> playResult;

    public Result(){
        playResult=new ArrayList<>();
        List<String> up=new ArrayList<>();
        List<String> down=new ArrayList<>();
        playResult.add(up);
        playResult.add(down);
    }
    public void addResult(String moving, String result){
        if(moving.equals(Constants.MOVE_UP)){
            playResult.get(0).add(result);
            playResult.get(1).add(Constants.NOTHING);
            return;
        }
        playResult.get(0).add(Constants.NOTHING);
        playResult.get(1).add(result);
    }
    public List<List<String>> getPlayResult(){ return playResult; }
}
