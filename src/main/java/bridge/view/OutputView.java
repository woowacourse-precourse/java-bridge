package bridge.view;

import static bridge.constant.BridgeConstant.LOWER_BLOCK;
import static bridge.constant.BridgeConstant.UPPER_BLOCK;

import bridge.FinalMessage;
import bridge.MessageToResult;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String BLANK = " ";

    private final List<String> upperBlocks = new ArrayList<>();
    private final List<String> lowerBlocks = new ArrayList<>();

    public void printMap(MessageToResult messageToResult) {
        String answer = messageToResult.getMessage();
        String resultMark = getResultMark(messageToResult.isCorrect());
        setBlocks(answer, resultMark);

        printEachMessage(upperBlocks);
        printEachMessage(lowerBlocks);
    }

    private String getAnswer(List<String> bridge) {
        return bridge.get(upperBlocks.size());
    }

    private String getResultMark(boolean isCorrect) {
        if (isCorrect) {
            return "O";
        }
        return "X";
    }

    private void setBlocks(String answer, String resultMark) {
        if (answer.equals(UPPER_BLOCK)) {
            upperBlocks.add(resultMark);
            lowerBlocks.add(BLANK);
        }

        if (answer.equals(LOWER_BLOCK)) {
            upperBlocks.add(BLANK);
            lowerBlocks.add(resultMark);
        }
    }

    private void printEachMessage(List<String> blocks) {
        String combinedMessage = String.join(" | ", blocks);
        System.out.printf("[ %s ]\n", combinedMessage);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void clear() {
        upperBlocks.clear();
        lowerBlocks.clear();
    }

    public void printFinalMessage(FinalMessage finalMessage) {
        System.out.println("최종 게임 결과");
        printEachMessage(upperBlocks);
        printEachMessage(lowerBlocks);
        System.out.printf("게임 성공 여부: %s\n", getIsGameClear(finalMessage));
        System.out.printf("총 시도한 횟수: %s\n", finalMessage.getTryCount());
    }

    private String getIsGameClear(FinalMessage finalMessage) {
        if (finalMessage.isGameClear()) {
            return "성공";
        }
        return "실패";
    }
}
