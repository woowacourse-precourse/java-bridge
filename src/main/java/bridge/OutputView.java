package bridge;
import java.util.List;

public class OutputView {
    public void printMap(List<List<String>> moveMap) {
        for (List<String> map : moveMap){
            System.out.println(map.toString().replace(", ","|"));
        }
        System.out.println();
    }
    public void printResult(BridgeGameController bridgeGameController, BridgeGame bridgeGame, boolean successStatus) {
        printResultLine();
        this.printMap(bridgeGame.statusMap);
        System.out.println("게임 성공 여부: " + checkIfSucceed(successStatus));
        System.out.println("총 시도한 횟수: " + bridgeGameController.getTryCount());
    }
    private String checkIfSucceed(boolean availableToMove) {
        if (availableToMove) {
            return "성공";
        }
        return "실패";
    }
    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
    public void printInputBridgeSize(){
        System.out.println("\n다리의 길이를 입력해주세요.");
    }
    public void printInputMove() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }
    public void printInputGameCommand(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
    private void printResultLine() {
        System.out.println("\n최종 게임 결과");
    }
}
