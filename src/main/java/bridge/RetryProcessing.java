package bridge;

import java.util.List;
import java.util.stream.Collectors;

public class RetryProcessing {

    private final InputView inputView;
    private final OutputView outputView;

    public RetryProcessing() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    /**
     * 게임을 다시 시도하기 위해 입력을 받는 메소드다
     */
    public boolean readRetry() {
        while (true) {
            OutputGameMessage.RETRY_INPUT_MESSAGE.printMessage();
            String input = inputView.readGameCommand();
            if (input.length() == 0) {
                continue;
            }
            boolean doRetry = inputRetryCommand(input);
            return doRetry;
        }
    }

    /**
     * 최종적으로 입력된 다리의 정보를 정해진 출력 형식으로 가공한다.
     */
    public void printResult(final List<String> upSide,final List<String> downSide,final int count) {
        String upSideBridge = upSide.stream().collect(Collectors.joining(" | ", "[ ", " ]"));
        String downSideBridge = downSide.stream().collect(Collectors.joining(" | ", "[ ", " ]"));
        outputView.printResult(upSideBridge, downSideBridge, count);
    }

    /**
     * 리트라이를 할 때 R을 눌렀는지 아닌지 확인
     */
    private boolean inputRetryCommand(final String inputCommand) {
        boolean doRetry = inputCommand.equals("R");

        return doRetry;
    }
}
