package bridge;

class BridgeMessage {
    StringBuilder s1;
    StringBuilder s2;

    public BridgeMessage() {
        s1 = new StringBuilder("[");
        s2 = new StringBuilder("[");
    }

    public void add(String a, String b) {
        this.s1.append(a);
        this.s2.append(b);
    }

    public String get() {
        return s1 + "\n" + s2;
    }
}