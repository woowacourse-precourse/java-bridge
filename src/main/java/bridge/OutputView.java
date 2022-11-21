package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private List<List<String>> mapList;

    public OutputView() {
        mapList = new ArrayList<>();
        mapList.add(List.of());
        mapList.add(List.of());
        System.out.println("CHECK"+mapList);
    }

    public void printMap(BirdgeMoveType isPossibleMove) {

        List<List<String>> move=checkIndex(isPossibleMove);
        List<String> resultList = printMapBorder(move);
        for (String result:
                resultList) {
            System.out.print(result);
        }
        System.out.println("\n");
    }
    public List<List<String>> checkIndex(BirdgeMoveType whereMove){

        if(whereMove.getIndex()==0){
            mapList.get(whereMove.getIndex()).add("| "+whereMove.getCode()+" ");
            mapList.get(whereMove.getIndex()+1).add("|   ");
        } else if (whereMove.getIndex()==1) {
            mapList.get(whereMove.getIndex()-1).add("|   ");
            mapList.get(whereMove.getIndex()).add("| "+whereMove.getCode()+" ");
        }
        return mapList;
    }
    public List<String> printMapBorder(List<List<String>> mapView){
        List<String> result=new ArrayList<>();
        System.out.println("C  "+mapView);
        for (List<String> map: mapView) {
            String resultText="";
            System.out.println(map);
            for (String mapText: map) { resultText+=mapText; }
            String formatString="["+resultText.substring(1)+"]";
            result.add(formatString);
        }
        return result;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
