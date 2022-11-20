package bridge.view;

import bridge.dto.output.PrintExceptionDto;
import bridge.dto.output.PrintGameInfoDto;
import bridge.dto.output.PrintMapDto;
import bridge.dto.output.PrintResultDto;

public class OutputView {

    private static final String SUCCESS = "성공";
    private static final String FAILED = "실패";

    public void printMap(PrintMapDto printMapDto) {
        String upBridgeHistory = printMapDto.getUpBridgeHistory();
        String downBridgeHistory = printMapDto.getDownBridgeHistory();

        print(OutputViewMessage.HISTORY_FORMAT.getFullMessage(upBridgeHistory));
        print(OutputViewMessage.HISTORY_FORMAT.getFullMessage(downBridgeHistory));
        printNewLine();
    }

    public void printResult(PrintResultDto printResultDto) {
        PrintMapDto printMapDto = printResultDto.getPrintMapDto();
        printMap(printMapDto);

        PrintGameInfoDto printGameInfoDto = printResultDto.getPrintGameInfoDto();
        boolean success = printGameInfoDto.isSuccess();
        long tryCount = printGameInfoDto.getTryCount();

        print(OutputViewMessage.GAME_RESULT.getFullMessage(successMapToMessage(success)));
        print(OutputViewMessage.GAME_TRY_COUNT.getFullMessage(tryCount));
    }

    public void printException(PrintExceptionDto printExceptionDto) {
        String exceptionMessage = printExceptionDto.getMessage();

        print(OutputViewMessage.EXCEPTION.getFullMessage(exceptionMessage));
    }

    private String successMapToMessage(boolean success) {
        if (success) {
            return SUCCESS;
        }
        return FAILED;
    }

    private void print(String message) {
        System.out.println(message);
    }

    private void printNewLine() {
        System.out.println();
    }

    private enum OutputViewMessage {
        EXCEPTION("[ERROR] %s"),
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
