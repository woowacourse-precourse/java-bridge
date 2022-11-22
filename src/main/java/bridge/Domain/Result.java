package bridge.Domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<List<String>> map;
    private String isSuccess;
    private int tryCount;

    public Result(){
        map = new ArrayList<>();

        for(int i = 0;i<2;i++){
            map.add(new ArrayList<>());
        }

        isSuccess = "실패";
        tryCount = 1;
    }

    public void makeMap(String move, String space){
        successGoUp(move, space);

        successGoDown(move, space);

        failGoUp(move, space);

        failGoDown(move, space);
    }

    public void successGoUp(String move, String space){
        if(move.equals("U") && space.equals("U")){
            map.get(0).add("O");
            map.get(1).add(" ");
        }
    }

    public void successGoDown(String move, String space){
        if(move.equals("D") && space.equals("D")){
            map.get(0).add(" ");
            map.get(1).add("O");
        }
    }

    public void failGoUp(String move, String space){
        if(move.equals("U") && space.equals("D")){
            map.get(0).add("X");
            map.get(1).add(" ");
        }
    }

    public void failGoDown(String move, String space){
        if(move.equals("D") && space.equals("U")){
            map.get(0).add(" ");
            map.get(1).add("X");
        }
    }

    public void retry(){
        map.clear();

        for(int i = 0;i<2;i++){
            map.add(new ArrayList<>());
        }

        tryCount++;
    }

    public void addTryCount(){
        tryCount++;
    }

    public List<List<String>> getMap() {
        return map;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    @Override
    public String toString() {
        return "최종 게임 결과\n" +
                replaceMapStringForm() +
                "\n게임 성공 여부: " + isSuccess +
                "\n총 시도한 횟수: " + tryCount;
    }

    public String replaceMapStringForm(){
        StringBuffer sb = new StringBuffer();

        for(List<String> row : map){
            sb.append(row.toString()
                    .replace("[", "[ ")
                    .replaceAll(",", " |")
                    .replace("]", " ]\n"));
        }

        return sb.toString();
    }
}
