package bridge.config;

import java.util.concurrent.Callable;

public abstract class GameActivity {

    private boolean stopped = false;

    /**
     * 액티비티의 라이프사이클을 시작한다.
     * @see #onStop()
     * @see #onLoop()
     * @see #onStop()
     */
    public final void run() {
        onStart();
        while (!stopped) {
            onLoop();
        }
        onStop();
    }

    /**
     * 예외 없이 결과를 반환할 때까지 반복
     * <p>
     * {@link #onError(Exception)}에서 예외 핸들링 방법을 지정할 수 있다.
     * <p>
     * 이외의 문장에서 발생한 예외는 자동으로 핸들링하지 않는다.
     * @param callable 반환이 있는 실행문
     * @return 반환 결과
     */
    public final <T> T executeUntilNoException(Callable callable) {
        while (true) {
            try {
                return (T) callable.call();
            } catch (Exception e) {
                onError(e);
            }
        }
    }

    /**
     * 예외 없이 수행에 성공할 때까지 반복
     * <p>
     * {@link #onError(Exception)}에서 예외 핸들링 방법을 지정할 수 있다.
     * <p>
     * 이외의 문장에서 발생한 예외는 자동으로 핸들링하지 않는다.
     * @param runnable 반환이 없는 실행문
     */
    public final void executeUntilNoException(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                return;
            } catch (IllegalArgumentException e) {
                onError(e);
            }
        }
    }

    /**
     * 루프 실행 전 한 번만 실행할 내용
     */
    protected abstract void onStart();

    /**
     * 라이프사이클 동안 반복할 내용
     * <p>
     * 명시적으로 {@link #stop()}을 호출하기 전까지 반복한다.
     * @see #stop()
     */
    protected abstract void onLoop();

    /**
     * 루프 종료 후 한 번만 실행할 내용
     */
    protected abstract void onStop();

    /**
     * {@link #executeUntilNoException(Callable)}과 {@link #executeUntilNoException(Runnable)}에서
     * 예외가 발생하였을 때 catch 후 원하는 작업
     * @param e 예외
     */
    protected abstract void onError(Exception e);

    /**
     * 라이프사이클 루프를 정상 종료한다.
     * <p>
     * 현재 실행 중인 {@link #onLoop()} 문장이 끝난 이후에 정상적으로 종료된다.
     * @see #onLoop()
     * @see #onStop()
     */
    protected void stop() {
        this.stopped = true;
    }

}
