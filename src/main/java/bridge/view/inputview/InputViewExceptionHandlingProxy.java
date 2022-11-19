package bridge.view.inputview;

import bridge.view.outputview.OutputView;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InputViewExceptionHandlingProxy implements InvocationHandler {
    private final Object target;
    private final OutputView outputView;

    public InputViewExceptionHandlingProxy(Object target, OutputView outputView) {
        this.target = target;
        this.outputView = outputView;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            return method.invoke(target, args);
        } catch (InvocationTargetException exception) {
            if (exception.getCause().getClass() == IllegalArgumentException.class) {
                outputView.printErrorMessage(exception.getCause());
                return invoke(proxy, method, args);
            }
            throw exception.getCause();
        }
    }
}
