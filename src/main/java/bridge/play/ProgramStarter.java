package bridge.play;

import bridge.service.GameSequence;
import bridge.view.OutputView;

public class ProgramStarter {

    public static void startProgram() {
        try {
            GameSequence.play();
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.errorMessageLogger(illegalArgumentException);
        }
    }

}
