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

    public void makeMap(List<String> spaces, List<String> moves){

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
