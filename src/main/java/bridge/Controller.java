package bridge;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;

    private BridgeGame bridgeGame;

    public Controller() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    private int makeBridge() {
        int size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);
        System.out.println(bridge);
        this.bridgeGame = new BridgeGame(bridge);
        return size;
    }

    private String isCorrect(String correct){
        if(correct.contains("C"))
            return OutputView.Message.SUCCESS.get();
        return OutputView.Message.FAILURE.get();
    }

    private void RoundGame(int size) {
        int count = 0;
        List<String> current_map = new ArrayList<>();
        String correct = "0";
        while(current_map.size() < size) {
            String move = inputView.readMoving();
            correct = bridgeGame.move(current_map.size(), move);
            current_map.add(correct);
            outputView.printMap(current_map);
            ++count;
            if(!correct.contains("C")) {
                if(inputView.readGameCommand().equals("R")){
                    current_map.clear();
                }
                else
                    break;
            }
        }
        outputView.printResult(current_map, count, isCorrect(correct));
    }

    public void bridgeGame() {
        int size;
        outputView.printStart();
        size = makeBridge();
        RoundGame(size);
    }
}
