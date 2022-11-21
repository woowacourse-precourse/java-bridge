package bridge;


// 코드 변경 불가
// int number = bridgeNumberGenerator.generate(); 와 같이 값 추출
@FunctionalInterface
public interface BridgeNumberGenerator {

    int generate();
}
