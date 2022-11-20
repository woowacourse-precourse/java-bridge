package bridge;

import bridge.view.DefaultView;
import bridge.view.OutputView;
import bridge.view.View;

public class ContextFactory {

    private static ContextFactory instance;

    private final OutputView outputView;
    private final View view;

    public static ContextFactory getInstance() {
        if (instance == null) {
            instance = new ContextFactory();
        }

        return instance;
    }

    private ContextFactory() {
        this.outputView = new OutputView();
        view = new DefaultView(this.outputView);
    }

    public View getView() {
        return this.view;
    }
}
