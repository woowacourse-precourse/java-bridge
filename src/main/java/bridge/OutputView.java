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
    private List<ArrayList<String>> mapList;

    public OutputView() {
        mapList = new ArrayList<>();
        mapList.add(new ArrayList<>());
        mapList.add(new ArrayList<>());
    }

    public boolean printMap(BirdgeMoveType isPossibleMove,InputView inputView,BridgeGame bridgeGame) {

        checkIndex(isPossibleMove);

        printMapDetail(mapList);
        return checkPrintResult(inputView,bridgeGame,isPossibleMove);
    }
    public void printMapDetail(List<ArrayList<String>> map){
        List<String> resultList = printMapBorder(map);
        for (String result:
                resultList) {
            System.out.println(result);
        }
        System.out.println("\n");
    }
    public List<ArrayList<String>> checkIndex(BirdgeMoveType whereMove){

        if(whereMove.getIndex()==0){
            mapList.get(whereMove.getIndex()).add("| "+whereMove.getCode()+" ");
            mapList.get(whereMove.getIndex()+1).add("|   ");
        } else if (whereMove.getIndex()==1) {
            mapList.get(whereMove.getIndex()-1).add("|   ");
            mapList.get(whereMove.getIndex()).add("| "+whereMove.getCode()+" ");
        }
        return mapList;
    }
    public List<String> printMapBorder(List<ArrayList<String>> mapView){
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
    public void printResult(BridgeGame bridgeGame) {
        System.out.println(String.format("총 시도한 횟수: %d",bridgeGame.getTryCount()));
    }
    public boolean checkPrintResult(InputView inputView,BridgeGame bridgeGame,BirdgeMoveType isPossibleMove){
        printLastResult();
        if(inputView.checkBridgeSize(mapList.get(0).size())&&isPossibleMove.getCode().equals("O")){
            System.out.println("게임 성공 여부: 성공");
            printResult(bridgeGame);
            return true;
        }
        return false;
    }

    public void printLastResult(){
        System.out.println("최종 게임 결과");
        printMapDetail(mapList);
    }
}
