package bridge.view;

import bridge.service.dto.response.BridgeResponseDto;
import bridge.service.dto.response.GameResultResponseDto;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String PRINT_START_GAME = "다리 건너기 게임을 시작합니다.";
    private static final String START_BRIDGE = "[ ";
    private static final String END_BRIDGE = " ]";
    private static final String SPLIT_BRIDGE = " | ";
    private static final String FINAL_GAME_RESULT = "최종 게임 결과";
    private static final String GAME_SUCCESS_OR_FAIL = "게임 성공 여부: ";
    private static final String TOTAL_TRY_NUMBER = "총 시도한 횟수: ";

    public void printStart() {
        System.out.println(PRINT_START_GAME);
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeResponseDto dto) {
        System.out.print(START_BRIDGE);
        for (int i = 0; i < dto.getUpSpaces().size(); i++) {
            System.out.print(dto.getUpSpaces().get(i));
            if (i < dto.getUpSpaces().size() - 1) {
                System.out.print(SPLIT_BRIDGE);
            } else {
                System.out.println(END_BRIDGE);
                break;
            }
        }

        System.out.print(START_BRIDGE);
        for (int i = 0; i < dto.getDownSpaces().size(); i++) {
            System.out.print(dto.getDownSpaces().get(i));
            if (i < dto.getDownSpaces().size() - 1) {
                System.out.print(SPLIT_BRIDGE);
            } else {
                System.out.println(END_BRIDGE);
                break;
            }
        }
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameResultResponseDto dto) {
        System.out.println(FINAL_GAME_RESULT);
        System.out.print(START_BRIDGE);
        for (int i = 0; i < dto.getUpSpaces().size(); i++) {
            System.out.print(dto.getUpSpaces().get(i));
            if (i < dto.getUpSpaces().size() - 1) {
                System.out.print(SPLIT_BRIDGE);
            } else {
                System.out.println(END_BRIDGE);
                break;
            }
        }

        System.out.print(START_BRIDGE);
        for (int i = 0; i < dto.getDownSpaces().size(); i++) {
            System.out.print(dto.getDownSpaces().get(i));
            if (i < dto.getDownSpaces().size() - 1) {
                System.out.print(SPLIT_BRIDGE);
            } else {
                System.out.println(END_BRIDGE);
                break;
            }
        }
        System.out.println();
        System.out.println(GAME_SUCCESS_OR_FAIL + dto.getGameSuccessOrFail());
        System.out.println(TOTAL_TRY_NUMBER + dto.getTotalTryNumber());
    }
}