package view;

import bridge.BridgeGame;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String FINAL_GAME_RESULT_MESSAGE = "최종 게임 결과";
    private static final String GAME_SUCCESS_MESSAGE = "게임 성공 여부: 성공";
    private static final String GAME_FAILURE_MESSAGE = "게임 성공 여부: 실패";
    private static final String FINAL_GAME_COUNT_MESSAGE = "총 시도한 횟수: ";
    private static final String MOVING_SELECT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String START_GAME_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String RETRY_SELECT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        System.out.println(BridgeGame.getUpSideBridge());
        System.out.println(BridgeGame.getDownSideBridge());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println(FINAL_GAME_RESULT_MESSAGE);
        System.out.println(BridgeGame.getUpSideBridge());
        System.out.println(BridgeGame.getDownSideBridge());

        if(BridgeGame.getIsPlayerFailed()){
            System.out.println(GAME_FAILURE_MESSAGE);
        }
        if(!BridgeGame.getIsPlayerFailed()){
            System.out.println(GAME_SUCCESS_MESSAGE);
        }
        System.out.println(FINAL_GAME_COUNT_MESSAGE + BridgeGame.getGameCount());
    }

    public void printMovingSelect(){
        System.out.println(MOVING_SELECT_MESSAGE);
    }

    public void printStartMessage(){
        System.out.println(START_GAME_MESSAGE);
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
    }

    public void printRetryMessage(){
        System.out.println(RETRY_SELECT_MESSAGE);
    }
}
