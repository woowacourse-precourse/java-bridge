package bridge;

import java.util.ArrayList;
import java.util.List;
public class OutputView {
    public void printMap(List<String> bridge,String direction, boolean result) {
        List<List<String>> bridgeMap = bridgeDivision(bridge);
        bridgeMap=bridgeLastDivision(bridgeMap,direction,result);
        for (List<String> directions:bridgeMap) {
            System.out.print("[");
            printDirection(directions);
            System.out.println("]");
        }
    }
    private void printDirection(List<String> direction){
        for(int count=0; count<direction.size(); count++) {
            System.out.print(" "+direction.get(count)+" ");
            if(count!=direction.size()-1)    System.out.print("|");
        }
    }
    private List<List<String>> bridgeFilter(List<List<String>> bridgeMap,String direction,String mark){
        if(direction.equals("U")){
            bridgeMap.get(0).add(mark);
            bridgeMap.get(1).add(" ");
        }
        else if (direction.equals("D")){
            bridgeMap.get(1).add(mark);
            bridgeMap.get(0).add(" ");
        }
        return bridgeMap;
    }
    private List<List<String>> bridgeLastDivision(List<List<String>> bridgeMap,String direction, boolean result){
        if(result) return bridgeFilter(bridgeMap,direction,"O");
        return bridgeFilter(bridgeMap,direction,"X");
    }
    private List<List<String>> bridgeDivision(List<String> bridge){
        List<List<String>> bridgeMap =new ArrayList<>();
        bridgeMap.add(new ArrayList<String>());
        bridgeMap.add(new ArrayList<String>());
        for (String direction: bridge) {
            bridgeMap=bridgeFilter(bridgeMap,direction,"O");
        }
        return bridgeMap;
    }
    private void printBridge(List<String> bridge,String direction, boolean result){
        System.out.println("최종 게임 결과");
        printMap(bridge,direction,result);
    }
    public void printResult(int count,String result) {
        System.out.println("게임 성공 여부: "+result);
        System.out.println("총 시도한 횟수: "+count);
    }
}
