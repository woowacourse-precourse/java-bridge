package bridge.view;


import bridge.domain.GameResult;
import bridge.domain.BridgeState;
import bridge.dto.BridgeDto;
import bridge.dto.GameResultDto;

import java.util.List;
import java.util.stream.IntStream;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String GAME_RESULT_MESSAGE = "최종 게임 결과";
    private static final String GAME_STATE_MESSAGE = "게임 성공 여부: %s";
    private static final String TOTAL_TRY_COUNT_MESSAGE = "총 시도한 횟수: %d";


    public void printStartingMessage() {
        System.out.println(GAME_START_MESSAGE);
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeDto bridgeDto) {
        getMap(bridgeDto);
    }

    private void getMap(BridgeDto bridgeDto) {
        for (List<BridgeState> stateOfBridge : bridgeDto.toList()) {
            printStartOfBridge();
            printBridgeMark(stateOfBridge);
            printEndOfBridge();
        }
        System.out.println();
    }

    private void printBridgeMark(List<BridgeState> stateOfBridge) {
        int bound = stateOfBridge.size() - 1;
        IntStream.range(0, bound)
                .mapToObj(i -> stateOfBridge.get(i).getMark())
                .forEach(i -> {
                    System.out.print(i);
                    printPartitionOfBridge();
                });
        System.out.print(stateOfBridge.get(bound).getMark());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * 메서드 명 변경 불가
     */
    public void printResult(BridgeDto bridgeDto, GameResultDto dto) {
        System.out.println(GAME_RESULT_MESSAGE);
        getMap(bridgeDto);
        printSuccessOrFailure(dto.getGameResult());
        printTryCount(dto.getTryCount());
    }

    private void printSuccessOrFailure(GameResult gameResult) {
        String formatted = String.format(GAME_STATE_MESSAGE, gameResult.getKorState());
        System.out.println(formatted);
    }

    private void printTryCount(int count) {
        String formatted = String.format(TOTAL_TRY_COUNT_MESSAGE, count);
        System.out.print(formatted);
    }

    public void printStartOfBridge() {
        System.out.print(BridgeState.START.getMark());
    }

    public void printEndOfBridge() {
        System.out.println(BridgeState.END.getMark());
    }

    public void printPartitionOfBridge() {
        System.out.print(BridgeState.PARTITION.getMark());
    }

}
