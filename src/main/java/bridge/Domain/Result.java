package bridge.Domain;

import bridge.Constants;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<List<String>> map;
    private String crossBridgeResult;
    private int tryCount;

    public Result(){
        map = new ArrayList<>();

        for(int i = 0;i<2;i++){
            map.add(new ArrayList<>());
        }

        crossBridgeResult = Constants.FAIL;
        tryCount = 1;
    }

    public void makeMap(String move, String space){
        successGoUp(move, space);

        successGoDown(move, space);

        failGoUp(move, space);

        failGoDown(move, space);
    }

    public void successGoUp(String move, String space){
        if(move.equals(Constants.UP) && space.equals(Constants.UP)){
            map.get(0).add(Constants.CORRECT);
            map.get(1).add(Constants.BLANK);
        }
    }

    public void successGoDown(String move, String space){
        if(move.equals(Constants.DOWN) && space.equals(Constants.DOWN)){
            map.get(0).add(Constants.BLANK);
            map.get(1).add(Constants.CORRECT);
        }
    }

    public void failGoUp(String move, String space){
        if(move.equals(Constants.UP) && space.equals(Constants.DOWN)){
            map.get(0).add(Constants.WRONG);
            map.get(1).add(Constants.BLANK);
        }
    }

    public void failGoDown(String move, String space){
        if(move.equals(Constants.DOWN) && space.equals(Constants.UP)){
            map.get(0).add(Constants.BLANK);
            map.get(1).add(Constants.WRONG);
        }
    }

    public void retry(){
        map.clear();

        for(int i = 0;i<2;i++){
            map.add(new ArrayList<>());
        }

        tryCount++;
    }

    public List<List<String>> getMap() {
        return map;
    }

    public void setCrossBridgeResult(String crossBridgeResult) {
        this.crossBridgeResult = crossBridgeResult;
    }

    @Override
    public String toString() {
        return "최종 게임 결과\n" +
                replaceMapStringForm() +
                "\n게임 성공 여부: " + crossBridgeResult +
                "\n총 시도한 횟수: " + tryCount;
    }

    public String replaceMapStringForm(){
        StringBuffer sb = new StringBuffer();

        for(List<String> row : map){
            sb.append(row.toString()
                    .replace("[", Constants.BRIDGE_START)
                    .replaceAll(", ", Constants.BRIDGE_DIVIDING_LINE)
                    .replace("]", Constants.BRIDGE_END));
        }

        return sb.toString();
    }
}
