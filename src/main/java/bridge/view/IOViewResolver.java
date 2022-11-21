package bridge.view;

import bridge.dto.input.ReadBridgeSizeDto;
import bridge.dto.input.ReadGameCommandDto;
import bridge.dto.input.ReadMovingDto;
import bridge.dto.output.PrintExceptionDto;
import bridge.dto.output.PrintMapDto;
import bridge.dto.output.PrintResultDto;
import bridge.exception.view.NotFoundViewException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class IOViewResolver {

    private final Map<Class<?>, Consumer<Object>> outputViewMappings = new HashMap<>();
    private final Map<Class<?>, Supplier<Object>> inputViewMappings = new HashMap<>();

    public IOViewResolver(final InputView inputView, final OutputView outputView) {
        initInputViewMappings(inputView);
        initOutputViewMappings(outputView);
    }

    private void initInputViewMappings(final InputView inputView) {
        inputViewMappings.put(ReadBridgeSizeDto.class, inputView::readBridgeSize);
        inputViewMappings.put(ReadMovingDto.class, inputView::readMoving);
        inputViewMappings.put(ReadGameCommandDto.class, inputView::readGameCommand);
    }

    private void initOutputViewMappings(final OutputView outputView) {
        outputViewMappings.put(PrintMapDto.class, dto -> outputView.printMap((PrintMapDto) dto));
        outputViewMappings.put(PrintResultDto.class, dto -> outputView.printResult((PrintResultDto) dto));
        outputViewMappings.put(PrintExceptionDto.class, dto -> outputView.printException((PrintExceptionDto) dto));
    }

    public <T> T inputViewResolve(final Class<T> type) {
        try {
            return type.cast(inputViewMappings.get(type).get());
        } catch (NullPointerException e) {
            throw new NotFoundViewException();
        }
    }

    public void outputViewResolve(final Object dto) {
        try {
            outputViewMappings.get(dto.getClass()).accept(dto);
        } catch (NullPointerException e) {
            throw new NotFoundViewException();
        }
    }
}
