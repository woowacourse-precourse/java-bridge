package bridge.config;

public abstract class BaseGameActivity {

    private boolean stopped = false;

    public void run() {
        onStart();
        while (!stopped) {
            onLoop();
        }
        onStop();
    }

    protected abstract void onStart();
    protected abstract void onLoop();
    protected abstract void onStop();

    protected void stop() {
        this.stopped = true;
    }

}
