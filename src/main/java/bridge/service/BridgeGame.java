package bridge.service;

import java.util.List;

public class BridgeGame {
    private static int position;
    private static int trialCount = 0;
    private static boolean onMovableCompartment;

    public void initializeRound() {
        trialCount++;
        position = 0;
        onMovableCompartment = true;
    }

    public boolean isPlaying(List<String> bridge) {
        return onMovableCompartment && position < bridge.size();
    }

    public void move(String moving, List<String> bridge) {
        onMovableCompartment = bridge.get(position).equals(moving);
    }

    public void retry() {
    }

    public void addPosition() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public int getTrialCount() {
        return trialCount;
    }

    public boolean isOnMovableCompartment() {
        return onMovableCompartment;
    }
}
