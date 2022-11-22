package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public void printMap(List<String> bridgeStatus) {
        String bridgeUpStatus = "[ ", bridgeDownStatus = "[ ";
        List<String> currentStatus;
        for (int i = 0; i < bridgeStatus.size(); i++){
            currentStatus = getbridgeStatus(bridgeStatus, i);
            bridgeUpStatus += currentStatus.get(0) + "| ";
            bridgeDownStatus += currentStatus.get(1) + "| ";
        }
        bridgeUpStatus = bridgeUpStatus.replaceAll("[|] $", "\\]");
        bridgeDownStatus = bridgeDownStatus.replaceAll("[|] $", "\\]");
        System.out.printf(bridgeUpStatus + "\n" + bridgeDownStatus + "\n");
    }

    /**
     * 현재 다리 한 칸의 상태를 형식에 맞는 문자열로 반환한다.
     */
    private List<String> getbridgeStatus(List<String> bridgeStatus, int index) {
        if (bridgeStatus.get(index).charAt(0) == 'U'){
            if (bridgeStatus.get(index).charAt(1) == 'O'){
                return List.of("O ", "  ");
            }
            return List.of("X ", "  ");
        }
        if (bridgeStatus.get(index).charAt(1) == 'O'){
            return List.of("  ", "O ");
        }
        return List.of("  ", "X ");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     */
    public void printResult(List<String> bridgeStatus, boolean flag, int count) {
        System.out.println("최종 게임 결과");
        printMap(bridgeStatus);

        if (flag){
            System.out.println("\n게임 성공 여부: 성공");
            System.out.printf("총 시도한 횟수: %d\n", count);
            return;
        }
        System.out.println("\n게임 성공 여부: 실패");
        System.out.printf("총 시도한 횟수: %d\n", count);
    }

    /**
     * 게임 시작을 알리는 내용과 다리의 길이를 입력하도록 지시하는 내용을 출력한다.
     */
    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("\n다리의 길이를 입력해주세요.");
    }

    /**
     * 이동할 칸을 선택하도록 지시하는 내용을 출력한다.
     */
    public void printMoving() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    /**
     * 게임을 재시도할지 종료할지를 선택하도록 지시하는 내용을 출력한다.
     */
    public void printGameCommand() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
