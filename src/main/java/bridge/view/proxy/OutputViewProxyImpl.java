package bridge.view.proxy;

import bridge.util.message.GameSuccess;
import bridge.util.BridgePart;
import bridge.util.UpDown;
import bridge.util.message.SystemMessage;
import bridge.view.dto.PrintMapDto;
import bridge.view.dto.PrintResultDto;

import java.util.List;

public class OutputViewProxyImpl implements OutputViewProxy {
    private StringBuilder upOut;
    private StringBuilder downOut;

    OutputViewProxy outputViewProxy;

    public OutputViewProxyImpl(OutputViewProxy outputViewProxy) {
        this.outputViewProxy = outputViewProxy;
    }

    @Override
    public void printMap(PrintMapDto printMapDto) {
        String result = makeMapMessage(printMapDto);

        outputViewProxy.printMap(new PrintMapDto(result));
    }

    private String makeMapMessage(PrintMapDto printMapDto) {
        messageInit();

        addEdge(BridgePart.START_EDGE.getValue());
        addBridgeState(printMapDto);
        addEdge(BridgePart.END_EDGE.getValue());

        return (upOut + System.lineSeparator()
                + downOut + System.lineSeparator());
    }

    private void messageInit() {
        upOut = new StringBuilder();
        downOut = new StringBuilder();
    }

    private void addEdge(String edge) {
        upOut.append(edge);
        downOut.append(edge);
    }

    private void addBridgeState(PrintMapDto printMapDto) {
        beforeState(printMapDto.current, printMapDto.bridge);
        currentState(printMapDto.current, printMapDto.input, printMapDto.bridge);
    }

    private void beforeState(int current, List<String> bridge) {
        for (int i = 0; i < current; i++) {
            String state = bridge.get(i);
            setUpState(state, BridgePart.OK.getValue());
            setDownState(state, BridgePart.OK.getValue());

            upOut.append(BridgePart.PARTITION.getValue());
            downOut.append(BridgePart.PARTITION.getValue());
        }
    }

    private void currentState(int current, String input, List<String> bridge) {
        String expect = bridge.get(current);

        if (input.equals(expect)) {
            setUpState(input, BridgePart.OK.getValue());
            setDownState(input, BridgePart.OK.getValue());
            return;
        }

        setUpState(input, BridgePart.NO.getValue());
        setDownState(input, BridgePart.NO.getValue());
    }

    private void setUpState(String state, String answer) {
        String blank = BridgePart.BLANK.getValue();

        if (state.equals(UpDown.UP.getValue())) {
            addStates(upOut, blank, answer, blank);
            addStates(downOut, blank, blank, blank);
        }
    }

    private void setDownState(String state, String answer) {
        String blank = BridgePart.BLANK.getValue();

        if (state.equals(UpDown.DOWN.getValue())) {
            addStates(upOut, blank, blank, blank);
            addStates(downOut, blank, answer, blank);
        }
    }

    private void addStates(StringBuilder sb, String... messages){
        for (String message : messages) {
            sb.append(message);
        }
    }

    @Override
    public void printResult(PrintResultDto printResultDto) {
        String result = makeResultMessage(printResultDto);

        outputViewProxy.printResult(new PrintResultDto(result));
    }

    private String makeResultMessage(PrintResultDto printResultDto) {
        GameSuccess gameSuccess = GameSuccess.findMessage(printResultDto.isSuccess);
        String countMessage = SystemMessage.PLAY_COUNT.getMessage();

        return (SystemMessage.DONE.getMessage() + System.lineSeparator()
                + gameSuccess.getMessage() + System.lineSeparator()
                + String.format(countMessage, printResultDto.gameTry));
    }
}
