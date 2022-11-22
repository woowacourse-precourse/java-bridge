package bridge.View;

import bridge.BridgeGame;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String START_BRIDGE_POINT = "[ ";
    private static final String CLOSE_BRIDGE_POINT = " ]";
    private static final String MIDDLE_BRIDGE_POINT = " | ";
    private static final String FINAL_GAME_RESULT_MESSAGE = "최종 게임 결과";
    private static final String GAME_RESULT_MESSAGE = "게임 성공 여부: ";
    private static final String SUCCESS_MESSAGE = "성공";
    private static final String FAIL_MESSAGE = "실패";
    private static final String TOTAL_TRY_COUNT_MESSAGE = "총 시도한 횟수: ";

    private OutputView() {

    }
}