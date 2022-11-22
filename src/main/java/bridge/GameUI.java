package bridge;

public class GameUI {
    public void gameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void getBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void moving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void gameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public void gameResult() {
        System.out.println("최종 게임 결과");
    }

    public void gameSuccessOrFail() {
        System.out.print("게임 성공 여부: ");
    }

    public void gameTrying() {
        System.out.print("총 시도한 횟수: ");
    }
}
