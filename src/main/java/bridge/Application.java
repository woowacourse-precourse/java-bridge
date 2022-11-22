package bridge;

import bridge.view.DefaultView;

import javax.swing.text.View;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ApplicationContext context = ApplicationContext.getContext();
        DefaultView view = context.getView();

        view.render();
    }
}
