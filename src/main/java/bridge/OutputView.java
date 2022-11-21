package bridge;
import java.util.*;
/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    BridgeGame bridgeGame;

    public OutputView(BridgeGame bridgeGame){
        this.bridgeGame = bridgeGame;
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */


    public void printMap(List<String> bridgeInfo, int currentPos, String userChoice) {
        printUpperMap(bridgeInfo, currentPos, userChoice);
        printLowerMap(bridgeInfo, currentPos, userChoice);
    }
    /**
     * 다리의 위쪽 부분을 출력
     */
    private void printUpperMap(List<String> bridgeInfo, int currentPos, String userChoice) {
        System.out.print("[ ");

        for(int i = 0; i < currentPos; i++) {
            System.out.print(returnOorBlankForUpper(bridgeInfo, i));
            System.out.print("| ");
        }
        System.out.print(printUpperUserChoice(bridgeInfo, currentPos, userChoice));
        System.out.println("]");
    }
    private String returnOorBlankForUpper(List<String> bridgeInfo, int i) {
        if(bridgeInfo.get(i).equals("U")) {
            return "O ";
        }
        return "  ";
    }
    private String printUpperUserChoice(List<String> bridgeInfo, int currentPos, String userChoice) {
        if(userChoice.equals("U")){
            if(bridgeGame.move(bridgeInfo, userChoice, currentPos)) {
                return "O ";
            }
            return "X ";
        }
        return "  ";
    }
    /**
     * 다리의 아래쪽 부분을 출력
     */
    private void printLowerMap(List<String> bridgeInfo, int currentPos, String userChoice) {
        System.out.print("[ ");

        for(int i = 0; i < currentPos; i++) {
            System.out.print(returnOorBlankForLower(bridgeInfo, i));
            System.out.print("| ");
        }
        System.out.print(printLowerUserChoice(bridgeInfo, currentPos, userChoice));
        System.out.println("]");
        System.out.println();
    }
    private String returnOorBlankForLower(List<String> bridgeInfo, int i) {
        if(bridgeInfo.get(i).equals("D")) {
            return "O ";
        }
        return "  ";
    }
    private String printLowerUserChoice(List<String> bridgeInfo, int currentPos, String userChoice) {
        if(userChoice.equals("D")){
            if(bridgeGame.move(bridgeInfo, userChoice, currentPos)) {
                return "O ";
            }
            return "X ";
        }
        return "  ";
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isSuccess, List<String> bridgeInfo, int currentPos, String userChoice, BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeInfo, currentPos, userChoice);
        System.out.println("게임 성공 여부: " + successOrFail(isSuccess));
        System.out.println("총 시도한 횟수: " + bridgeGame.getTryCount());
    }
    private String successOrFail(boolean isSuccess) {
        if(isSuccess) {
            return "성공";
        }
        return "실패";
    }
}
