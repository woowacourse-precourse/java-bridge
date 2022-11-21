package bridge.view.inputview;

import bridge.view.outputview.OutputView;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 이 핸들러를 사용해 프록시 객체를 만들면
 * InputView 메서드 실행 중 IllegalArgumentException 발생 시
 * 메시지 출력 후 입력을 다시 받는 예외 핸들링을 진행할 수 있습니다.
 */
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
