package bridge.config;

import java.util.concurrent.Callable;

public abstract class GameActivity {

    private boolean stopped = false;

    public final void run() {
        onStart();
        while (!stopped) {
            onLoop();
        }
        onStop();
    }

    public final <T> T executeUntilNoException(Callable callable) {
        while (true) {
            try {
                return (T) callable.call();
            } catch (Exception e) {
                onError(e);
            }
        }
    }

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


    protected abstract void onStart();
    protected abstract void onLoop();
    protected abstract void onStop();
    protected abstract void onError(Exception e);

    protected void stop() {
        this.stopped = true;
    }

}
