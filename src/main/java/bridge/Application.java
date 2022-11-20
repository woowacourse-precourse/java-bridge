package bridge;

import bridge.view.View;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ContextFactory factory = ContextFactory.getInstance();
        View view = factory.getView();
        view.render();
    }
}
