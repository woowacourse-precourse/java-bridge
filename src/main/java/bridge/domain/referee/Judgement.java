package bridge.domain.referee;

public class Judgement {

    private final boolean judgement;

    public Judgement(boolean judgement) {
        this.judgement = judgement;
    }

    public boolean isTrue() {
        return judgement;
    }

    public boolean isFalse() {
        return !judgement;
    }

    @Override
    public String toString() {
        return "Judgement{" +
                "judgement=" + judgement +
                '}';
    }
}
