package bridge.view;

import bridge.dto.output.PrintExceptionDto;
import bridge.dto.output.PrintGameInfoDto;
import bridge.dto.output.PrintMapDto;
import bridge.dto.output.PrintResultDto;
import bridge.utils.common.BridgeConst;
import java.util.function.Consumer;

public class OutputView {

    private static final String NULL_STRING = "";

    private static final String SUCCESS = "성공";
    private static final String FAILED = "실패";

    private final Consumer<String> print;

    public OutputView(final Consumer<String> print) {
        this.print = print;
    }

    public void printMap(final PrintMapDto printMapDto) {
        String upBridgeHistory = printMapDto.getUpBridgeHistory();
        String downBridgeHistory = printMapDto.getDownBridgeHistory();

        print.accept(OutputViewMessage.HISTORY_FORMAT.getFullMessage(upBridgeHistory));
        print.accept(OutputViewMessage.HISTORY_FORMAT.getFullMessage(downBridgeHistory));
        print.accept(NULL_STRING);
    }

    public void printResult(final PrintResultDto printResultDto) {
        printMap(printResultDto.getPrintMapDto());

        PrintGameInfoDto printGameInfoDto = printResultDto.getPrintGameInfoDto();
        boolean success = printGameInfoDto.isSuccess();
        long tryCount = printGameInfoDto.getTryCount();

        print.accept(OutputViewMessage.GAME_RESULT.getFullMessage(MapToMessageFromSuccess(success)));
        print.accept(OutputViewMessage.GAME_TRY_COUNT.getFullMessage(tryCount));
    }

    public void printException(final PrintExceptionDto printExceptionDto) {
        String exceptionMessage = printExceptionDto.getMessage();

        print.accept(OutputViewMessage.EXCEPTION.getFullMessage(exceptionMessage));
    }

    private String MapToMessageFromSuccess(boolean success) {
        if (success) {
            return SUCCESS;
        }
        return FAILED;
    }

    private enum OutputViewMessage {
        EXCEPTION(BridgeConst.ERROR_FORMAT),
        HISTORY_FORMAT("[ %s ]"),
        GAME_RESULT("게임 성공 여부: %s"),
        GAME_TRY_COUNT("총 시도한 횟수: %d");

        private final String baseFormat;

        OutputViewMessage(String baseFormat) {
            this.baseFormat = baseFormat;
        }

        private String getFullMessage(Object replace) {
            return String.format(baseFormat, replace);
        }
    }
}
