package bridge.view.proxy;

import bridge.view.dto.PrintMapDto;
import bridge.view.dto.PrintResultDto;

public interface OutputViewProxy {

    void printMap(PrintMapDto printMapDto);

    void printResult(PrintResultDto printResultDto);
}
