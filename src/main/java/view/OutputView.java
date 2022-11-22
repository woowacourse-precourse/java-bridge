package view;


import java.util.List;
import data.BridgeData;
/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String HEAD = "[ ";
    private final String DIVIDER = "| ";
    private final String TAIL = "]";
    private final String SUCCESS = "O ";
    private final String FAIL = "X ";
    private final String NONE = "  ";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean printMap(List<String> bridge, List<String> player, int index) {
        if(bridge.get(index - 1).equals(player.get(index - 1))){ // 플레이어가 올바른 선택을 했을 경우
            printBridge(BridgeData.UP, player, true);
            printBridge(BridgeData.DOWN, player, true);
            System.out.println();
            return true;
        }
        printBridge(BridgeData.UP, player, false);
        printBridge(BridgeData.DOWN, player, false);
        System.out.println();
        return false;
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {

    }

    private void printBridge(String keyword, List<String> player, boolean isAlive) {
        System.out.print(HEAD);
        for(int index = 0; index < player.size(); index ++){
            if(index == player.size() - 1){ // 리스트이 끝에 도달했을 때
                printBridgeEnd(keyword, player.get(index), isAlive);
                break;
            }
            printBridgePiece(keyword, player.get(index));
        }
        System.out.println(TAIL);
    }

    private void printBridgeEnd(String keyword, String choice, boolean isAlive){
        if(!keyword.equals(choice)){
            System.out.print(NONE);
            return;
        }
        if(keyword.equals(choice) && isAlive){
            System.out.print(SUCCESS);
            return;
        }
        System.out.print(FAIL);
    }

    private void printBridgePiece(String keyword, String choice){
        if(keyword.equals(choice)){
            System.out.print(SUCCESS + DIVIDER);
            return;
        }
        System.out.print(NONE + DIVIDER);
    }
}
