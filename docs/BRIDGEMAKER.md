# 🔍 BridgeMaker
다리 건너기 게임에서 다리 생성을 담당하는 클래스이다.  
필드 혹은 메소드의 이름을 변경할 수 없다.     
`InputView`, `OutputView`를 사용할 수 없다.    
= `BridgeAnswer`, `Bridge`, `Move` 객체를 사용하여야 한다.

* __메소드 종류__
> * 다리 생성 `makeBridge()`

### 다리 생성 `makeBridge()`
> 1. 매개변수 `size` 만큼 반복 시행한다.
> > int number = bridgeNumberGenerator.generator()
> 
> 2. `number`이 1이면 `U`, 0이면 `D`를 저장한다.
> 3. `List<String>`을 반환한다.

### 재시작 `retry()`
> 1. `Move`의 값을 비교해서 `R`이면 `move()` 메소드를 호출한다.

