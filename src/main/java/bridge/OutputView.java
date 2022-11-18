package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    enum Guide {
        START("다리 건너기 게임을 시작합니다."),
        BRIDGESIZEINPUT("다리의 길이를 입력해주세요."),
        MOVECOMMANDINPUT("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
        RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        private final String message;
        Guide(String message) { this.message = message; }
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> map) {
        // TODO: map 출력 로직 구현
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isCorrect, List<String> path, int numberOfTry) {
        System.out.println("최종 게임 결과");
        printMap(path);
        System.out.print("게임 성공 여부: ");
        if(isCorrect) System.out.print("성공");
        if(!isCorrect) System.out.print("실패");
        System.out.printf("총 시도한 횟수: %d\n", numberOfTry);
    }

    public void printMessage(String message) { System.out.println(message); }

    private void guide(Guide guide) { System.out.println(guide.message); }

    public void guideStart() { guide(Guide.START); }
    public void guideBridgeSizeInput() { guide(Guide.BRIDGESIZEINPUT); }
    public void guideMovingCommandInput() { guide(Guide.MOVECOMMANDINPUT); }
    public void guideRetry() { guide(Guide.RETRY); }
}
