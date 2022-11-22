package bridge.view;

import java.io.FilterOutputStream;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printEnterBridgeLength(){
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printEnterMoving(){
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printEnterGameCommand(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
    
}
