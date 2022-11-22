package bridge.service;

import bridge.domain.Round;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;

public class RoundService {
    private Round round = new Round(new ArrayList<>());

    public void getMoving() {
        OutputView.messagePositionInput();
        round.addMoving(InputView.readMoving());
    }
}
