package bridge.view;

import bridge.dto.GameResultDTO;

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
    private static final String GAME_COMMAND_INPUT_MESSAGE = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String RESULT_GUIDANCE_MESSAGE = "\n최종 게임 결과";
    private static final String WHETHER_GAME_SUCCESS_MESSAGE_FORM = "\n게임 성공 여부: %s%n";
    private static final String NUMBER_OF_TRY_MESSAGE_FORM = "총 시도한 횟수: %s%n";
    private static final String NEW_LINE_DELIMITER = "\n";
    private static final String VERTICAL_DELIMITER = " | ";
    private static final String SQUARE_BRACKETS_PREFIX = "[ ";
    private static final String SQUARE_BRACKETS_SUFFIX = " ]";
    private static final String SPACE_DISPLAY = " ";
    private static final int BRIDGE_LINE_SIZE = 2;
    private static final int NUMBER_THAT_MEANS_PLACES_NOT_TO_WENT = 0;
    
    public void printGameStartMessage() {
        printMessage(GAME_START_MESSAGE);
    }
    
    public void printBridgeSizeInputMessage() {
        printMessage(BRIDGE_SIZE_INPUT_MESSAGE);
    }
    
    public void printMovingInputMessage() {
        printMessage(MOVING_INPUT_MESSAGE);
    }
    
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(GameResultDTO gameResultDTO) {
        printMessage(parseBridgeMapDisplay(gameResultDTO));
    }
    
    private String parseBridgeMapDisplay(final GameResultDTO gameResultDTO) {
        return IntStream.range(0, BRIDGE_LINE_SIZE)
                .mapToObj(lineIndex -> parseEachLineMapDisplay(gameResultDTO, lineIndex))
                .collect(Collectors.joining(NEW_LINE_DELIMITER));
    }
    
    private String parseEachLineMapDisplay(final GameResultDTO gameResultDTO, final int lineIndex) {
        return IntStream.range(0, countOfMoving(gameResultDTO))
                .mapToObj(countOfMoving -> parseMovingDisplay(gameResultDTO, countOfMoving, lineIndex))
                .collect(Collectors.joining(VERTICAL_DELIMITER, SQUARE_BRACKETS_PREFIX, SQUARE_BRACKETS_SUFFIX));
    }
    
    private int countOfMoving(final GameResultDTO gameResultDTO) {
        return moveResults(gameResultDTO).size();
    }
    
    private List<MoveResultDisplay> moveResults(final GameResultDTO gameResultDTO) {
        return gameResultDTO.getMoveResults();
    }
    
    private String parseMovingDisplay(final GameResultDTO gameResultDTO, final int countOfMoving, final int lineIndex) {
        if (isNotPlaceToMove(lineIndex, currentMoving(gameResultDTO, countOfMoving))) {
            return SPACE_DISPLAY;
        }
        
        return currentMovingResult(gameResultDTO, countOfMoving);
    }
    
    private String currentMoving(final GameResultDTO gameResultDTO, final int countOfMoving) {
        return movings(gameResultDTO).get(countOfMoving);
    }
    
    private List<String> movings(final GameResultDTO gameResultDTO) {
        return gameResultDTO.getMovings();
    }
    
    private boolean isNotPlaceToMove(final int lineIndex, final String currentMoving) {
        return numberOfWhetherToWent(lineIndex, currentMoving) == NUMBER_THAT_MEANS_PLACES_NOT_TO_WENT;
    }
    
    private int numberOfWhetherToWent(final int lineIndex, final String currentMoving) {
        return (currentMoving.charAt(0) + lineIndex) % 2;
    }
    
    private String currentMovingResult(final GameResultDTO gameResultDTO, final int countOfMoving) {
        return currentMoveResult(gameResultDTO, countOfMoving).getMovingResult();
    }
    
    private MoveResultDisplay currentMoveResult(final GameResultDTO gameResultDTO, final int countOfMoving) {
        return moveResults(gameResultDTO).get(countOfMoving);
    }
    
    public void printGameCommandInputMessage() {
        printMessage(GAME_COMMAND_INPUT_MESSAGE);
    }
    
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(final GameResultDTO gameResultDTO) {
        printResultGuidanceMessage();
        printMap(gameResultDTO);
        
        printWhetherGameSuccess(gameResultDTO);
        printNumberOfTry(gameResultDTO);
    }
    
    private void printResultGuidanceMessage() {
        printMessage(RESULT_GUIDANCE_MESSAGE);
    }
    
    private void printWhetherGameSuccess(final GameResultDTO gameResultDTO) {
        printMessageForm(WHETHER_GAME_SUCCESS_MESSAGE_FORM, whetherGameSuccess(gameResultDTO));
    }
    
    private String whetherGameSuccess(final GameResultDTO gameResultDTO) {
        return lastMovingResult(gameResultDTO).getGameResult();
    }
    
    private MoveResultDisplay lastMovingResult(final GameResultDTO gameResultDTO) {
        return moveResults(gameResultDTO).get(countOfMoving(gameResultDTO) - 1);
    }
    
    private void printNumberOfTry(final GameResultDTO gameResultDTO) {
        printMessageForm(NUMBER_OF_TRY_MESSAGE_FORM, String.valueOf(numberOfTry(gameResultDTO)));
    }
    
    private int numberOfTry(final GameResultDTO gameResultDTO) {
        return gameResultDTO.getNumberOfTry();
    }
    
    public void printErrorMessage(final IllegalArgumentException raisedException) {
        printMessage(raisedException.getMessage());
    }
    
    private void printMessage(final String message) {
        System.out.println(message);
    }
    
    private void printMessageForm(final String messageForm, final String message) {
        System.out.printf(messageForm, message);
    }
}
