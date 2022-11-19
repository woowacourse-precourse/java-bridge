package bridge.view;



/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {


    public void printStartGame() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public void printChoiceBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printChoiceUpOrDown() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printChoiceRetry() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세여.(재시도: R, 종료: Q)");
    }


}
