package bridge.view.proxy;

import bridge.message.GameSuccess;
import bridge.util.BridgePart;
import bridge.util.UpDown;
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
        upOut = new StringBuilder();
        downOut = new StringBuilder();

        appendEdge(BridgePart.START_EDGE.getValue());

        beforeState(printMapDto.current, printMapDto.bridge);
        currentState(printMapDto.current, printMapDto.input, printMapDto.bridge);

        appendEdge(BridgePart.END_EDGE.getValue());

        String result = (upOut + System.lineSeparator()
                + downOut + System.lineSeparator());

        outputViewProxy.printMap(new PrintMapDto(result));
    }

    @Override
    public void printResult(PrintResultDto printResultDto) {
        GameSuccess gameSuccess = GameSuccess.findMessage(printResultDto.isSuccess);
        String result = "최종 게임 결과" + System.lineSeparator()
                + gameSuccess.getMessage() + System.lineSeparator()
                + String.format("총 시도한 횟수: %d%n", printResultDto.gameTry);

        outputViewProxy.printResult(new PrintResultDto(result));
    }

    private void appendEdge(String edge) {
        upOut.append(edge);
        downOut.append(edge);
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
        if (state.equals(UpDown.UP.getValue())) {
            upOut.append(BridgePart.BLANK.getValue())
                    .append(answer)
                    .append(BridgePart.BLANK.getValue());

            downOut.append(BridgePart.BLANK.getValue())
                    .append(BridgePart.BLANK.getValue())
                    .append(BridgePart.BLANK.getValue());
        }
    }

    private void setDownState(String state, String answer) {
        if (state.equals(UpDown.DOWN.getValue())) {
            upOut.append(BridgePart.BLANK.getValue())
                    .append(BridgePart.BLANK.getValue())
                    .append(BridgePart.BLANK.getValue());

            downOut.append(BridgePart.BLANK.getValue())
                    .append(answer)
                    .append(BridgePart.BLANK.getValue());
        }
    }
}
