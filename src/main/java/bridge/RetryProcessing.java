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

    //최종적으로 입력된 다리의 정보를 정해진 출력 형식으로 가공한다.
    public void printResult(List<String> upSide, List<String> downSide, int count){
        String upSideBridge = upSide.stream().collect(Collectors.joining(" | ", "[ ", " ]"));
        String downSideBridge = downSide.stream().collect(Collectors.joining(" | ", "[ ", " ]"));
        outputView.printResult(upSideBridge, downSideBridge, count);
    }

    //리트라이를 할 때 R을 눌렀는지 아닌지 확인
    private boolean inputRetryCommand(String inputCommand) {
        boolean doRetry = inputCommand.equals("R");

        return doRetry;
    }
}
