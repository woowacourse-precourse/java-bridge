package bridge.view;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printIntro() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public void printRequestBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printRequestMove() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printRequestGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> mark, boolean passable) {
        List<String> upperBridge = new ArrayList<>();
        List<String> loserBridge = new ArrayList<>();
        setBridge(upperBridge, mark,"U");
        setBridge(loserBridge, mark,"D");

        if (!passable){
            setImpassable(upperBridge,loserBridge);
        }
        printBridge(upperBridge);
        printBridge(loserBridge);
    }

    private void printBridge(List<String> bridge) {
        System.out.print("[ ");
        for(String spot : bridge){
            System.out.print(spot);
        }
        System.out.println(" ]");
    }

    private void setImpassable(List<String> upperBridge, List<String> loserBridge) {
        int size = upperBridge.size();

        if(upperBridge.get(size-1).equals("O")){ // upper 가 마지막 O
            upperBridge.set(size-1,"X");
            return;
        }
        loserBridge.set(size-1,"X");
    }

    private void setBridge(List<String> bridge, List<String> mark, String which) {
        for(String i :mark){
            if(i.equals(which)){
                bridge.add("O");
                bridge.add(" | ");
                continue;
            }
            bridge.add(" ");
            bridge.add(" | ");
        }
        bridge.remove(bridge.size()-1);
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
