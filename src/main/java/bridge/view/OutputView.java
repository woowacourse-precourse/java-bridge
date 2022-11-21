package bridge.view;

import bridge.view.dto.PrintMapDto;
import bridge.view.dto.PrintResultDto;
import bridge.view.proxy.OutputViewProxy;

public class OutputView implements OutputViewProxy {

    @Override
    public void printMap(PrintMapDto printMapDto) {
        System.out.print(printMapDto.result);
    }

    @Override
    public void printResult(PrintResultDto printResultDto) {
        System.out.print(printResultDto.result);
    }
}
