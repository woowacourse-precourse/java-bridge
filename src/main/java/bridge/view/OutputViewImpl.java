package bridge.view;

import bridge.data.dto.responseDto.FinalResultResponseDto;
import bridge.data.dto.responseDto.InGameCommandResponseDto;

public class OutputViewImpl implements OutputView{

    @Override
    public void printMessage(Object message) {
        System.out.println();
        System.out.println(message.toString());
    }

    @Override
    public void printMap(InGameCommandResponseDto responseDto) {
    }

    @Override
    public void printResult(FinalResultResponseDto responseDto) {
    }
}
