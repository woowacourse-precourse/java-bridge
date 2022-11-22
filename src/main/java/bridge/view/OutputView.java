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
    
}
