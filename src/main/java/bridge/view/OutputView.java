package bridge.view;

import bridge.domain.UserState;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printMap(String map) {
        System.out.println(map);
    }

    public void printResult(UserState userState, int bridgeSize) {
        System.out.println("최종 게임 결과");
        System.out.println(userState.toString());
        System.out.println("\n게임 성공 여부: " + getSuccessMessage(userState, bridgeSize));
        System.out.println("총 시도한 횟수: " + userState.getTryCount());
    }

    private String getSuccessMessage(UserState userState, int bridgeSize) {
        if (userState.isSuccessOrFail(bridgeSize)) {
            return "성공";
        }
        return "실패";
    }
}
