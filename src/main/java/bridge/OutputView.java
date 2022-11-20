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
    public void printMap(BirdgeMoveType isPossibleMove) {

        List<List<String>> move=checkIndex(isPossibleMove);
        List<String> resultList = printMapBorder(move);
        for (String result:
                resultList) {
            System.out.println(result);
        }
    }
    public List<List<String>> checkIndex(BirdgeMoveType whereMove){
        List<List<String>> mapList = new ArrayList<>();
        if(whereMove.getIndex()==0){
            mapList.add(whereMove.getIndex(),List.of("| "+whereMove.getCode()+" "));
            mapList.add(whereMove.getIndex()+1,List.of("|   "));
        } else if (whereMove.getIndex()==1) {
            mapList.add(whereMove.getIndex()-1,List.of("|   "));
            mapList.add(whereMove.getIndex(),List.of("| "+whereMove.getCode()+" "));
        }
        return mapList;
    }
    public List<String> printMapBorder(List<List<String>> mapView){
        List<String> result=new ArrayList<>();

        for (List<String> map: mapView) {
            String resultText="";
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
