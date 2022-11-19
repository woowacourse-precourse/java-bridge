package bridge.enums;

public enum ControlKey {
  UP("U", "위"){
    public String getPair() {
      return getKeyInKorean() + ": " + getKey();
    }
  },
  DOWN("D", "아래"){
    public String getPair() {
      return getKeyInKorean() + ": " + getKey();
    }
  },
  RETRY("R", "재시도"){
    public String getPair() {
      return getKeyInKorean() + ": " + getKey();
    }
  },
  QUIT("Q", "종료"){
    public String getPair() {
      return getKeyInKorean() + ": " + getKey();
    }
  };

  private String key;
  private String keyInKorean;

  ControlKey(String key, String keyInKorean) {
    this.key = key;
    this.keyInKorean = keyInKorean;
  }

  public String getKey() {
    return key;
  }

  public String getKeyInKorean() {
    return keyInKorean;
  }

  public abstract String getPair();

}
