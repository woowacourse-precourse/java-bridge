package bridge.view;


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
    public void printMap(List<String> bridgeView) {
        upPrintMap(bridgeView);
        downPrintMap(bridgeView);
        System.out.println();
    }

    public void upPrintMap(List<String> bridgeView) {
        System.out.print("[");
        for(int i = 0; i<upBridgeMap(bridgeView).size()-1; i++){
            System.out.print(" "+upBridgeMap(bridgeView).get(i)+" |");
        }
        System.out.println(" "+upBridgeMap(bridgeView).get(upBridgeMap(bridgeView).size()-1)+" ]");
    }

    public void downPrintMap(List<String> bridgeView) {
        System.out.print("[");
        for(int i = 0; i<downBridgeMap(bridgeView).size()-1; i++){
            System.out.print(" "+downBridgeMap(bridgeView).get(i)+" |");
        }
        System.out.println(" "+downBridgeMap(bridgeView).get(downBridgeMap(bridgeView).size()-1)+" ]");
    }
    private List<String> upBridgeMap(List<String> bridgeView){
        List<String> bridgeOutputUP = new ArrayList<>();
        for(int i =0; i<bridgeView.size(); i+=2){
            if((bridgeView.get(i)).equals("U")){
                bridgeOutputUP.add((bridgeView.get(i+1)));
            }
            if(!(bridgeView.get(i)).equals("U")){
                bridgeOutputUP.add(" ");
            }
        }
        return bridgeOutputUP;
    }
    private List<String> downBridgeMap(List<String> bridgeView){
        List<String> bridgeOutputDown = new ArrayList<>();
        for(int i =0; i<bridgeView.size(); i+=2){
            if((bridgeView.get(i)).equals("D")){
                bridgeOutputDown.add((bridgeView.get(i+1)));
            }
            if(!(bridgeView.get(i)).equals("D")){
                bridgeOutputDown.add(" ");
            }
        }
        return bridgeOutputDown;
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridgeView, String result, int count) {
        System.out.println("최종 게임 결과");
        printMap(bridgeView);
        System.out.println("게임 성공 여부: " +result);
        System.out.println("총 시도한 횟수: " +count);
    }
}
