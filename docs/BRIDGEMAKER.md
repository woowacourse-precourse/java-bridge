# 🔍 BridgeMaker

다리 건너기 게임에서 다리 생성을 담당하는 클래스이다.  
필드 혹은 메소드의 이름을 변경할 수 없다.

* __메소드 종류__

> * 다리 생성 `makeBridge()`
> * 랜덤 단어 만들기 `makeRandomBridgeWord`

### 다리 생성 `makeBridge()`

> 1. 매개변수 `size` 만큼 반복 시행한다.
> > int number = bridgeNumberGenerator.generator()
>
> 2. `number`이 1이면 `U`, 0이면 `D`를 저장한다.
> 3. `List<String>`을 반환한다.

### 랜덤 단어 만들기 `makeRandomBridgeWord()`

> 1. `bridgeNumberGenerator.generate()`가 1이면 `U`, 1이 아니면 `D`를 반환한다.

