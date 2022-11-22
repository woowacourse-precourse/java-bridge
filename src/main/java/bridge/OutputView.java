package bridge;

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
    public void printMap(BridgeGame bridgeGame) {
        printOneMap(bridgeGame.getUList(), bridgeGame.getIndex());
        printOneMap(bridgeGame.getDList(), bridgeGame.getIndex());
    }

    public void printOneMap(List<String> result, int index) {
        System.out.print("[");
        for (int i = 0; i < index; i++) {
            System.out.print(" " + result.get(i));
            if (i < index - 1) {
                System.out.print(" |");
            }
        }
        System.out.println(" ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
    
    public void printBridgeSizeQuestion() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printMovingQuestion() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printGameCommandQuestion() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public void printResult(BridgeGame bridgeGame, boolean SuccessOrFail) {
        System.out.println("최종 게임 결과");
        String status = "실패";
        printMap(bridgeGame);
        if (SuccessOrFail) {
            status = "성공";
        }
        System.out.println("게임 성공 여부: " + status);
        System.out.println("총 시도한 횟수: " + (bridgeGame.getCount() + 1));
    }

    public void printReadSizeError() {
        System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    public void printReadMovingError() {
        System.out.println("[ERROR] 움직일 수 있는 칸은 U와 D 뿐 입니다.");
    }

    public void printReadGameCommandError() {
        System.out.println("[ERROR] R과 Q만 입력하실 수 있습니다.");
    }
}
