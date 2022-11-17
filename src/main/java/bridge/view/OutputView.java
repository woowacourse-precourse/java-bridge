package bridge.view;

import bridge.domain.MoveResult;
import bridge.dto.ResultMapDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String BRIDGE_SIZE_INPUT_MESSAGE = "\n다리의 길이를 입력해주세요.";
    private static final String MOVING_INPUT_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final int BRIDGE_LINE_SIZE = 2;
    
    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }
    
    public void printBridgeSizeInputMessage() {
        System.out.println(BRIDGE_SIZE_INPUT_MESSAGE);
    }
    
    public void printMovingInputMessage() {
        System.out.println(MOVING_INPUT_MESSAGE);
    }
    
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(ResultMapDTO resultMapDTO) {
        System.out.println(parseBridgeMapDisplay(resultMapDTO));
    }
    
    private String parseBridgeMapDisplay(final ResultMapDTO resultMapDTO) {
        return IntStream.range(0, BRIDGE_LINE_SIZE)
                .mapToObj(lineIndex -> parseEachLineMapDisplay(resultMapDTO, lineIndex))
                .collect(Collectors.joining("\n"));
    }
    
    private String parseEachLineMapDisplay(final ResultMapDTO resultMapDTO, final int lineIndex) {
        return IntStream.range(0, resultMapDTO.getMovings().size())
                .mapToObj(countOfMoving -> parseMovingDisplay(resultMapDTO, countOfMoving, lineIndex))
                .collect(Collectors.joining(" | ", "[ ", " ]"));
    }
    
    private String parseMovingDisplay(final ResultMapDTO resultMapDTO, final int countOfMoving, final int lineIndex) {
        if (isNotPlaceToMove(lineIndex, movings(resultMapDTO).get(countOfMoving))) {
            return " ";
        }
        
        return parseMovingResultDisplay(moveResults(resultMapDTO).get(countOfMoving));
    }
    
    private List<String> movings(final ResultMapDTO resultMapDTO) {
        return resultMapDTO.getMovings();
    }
    
    private boolean isNotPlaceToMove(final int lineIndex, final String currentMoving) {
        return (currentMoving.charAt(0) + lineIndex) % 2 == 0;
    }
    
    private List<MoveResult> moveResults(final ResultMapDTO resultMapDTO) {
        return resultMapDTO.getMoveResults();
    }
    
    private String parseMovingResultDisplay(final MoveResult moveResult) {
        if (moveResult.isSuccess()) {
            return "O";
        }
        
        return "X";
    }
    
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
