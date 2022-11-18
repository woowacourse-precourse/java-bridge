# 🔍 BridgeGame

다리 건너기 게임에서 이동을 담당하는 클래스이다.  
메소드의 이름을 변경할 수 없으며, 필요하다면 메소드 추가는 가능하다.     
`InputView`, `OutputView`를 사용할 수 없다.    
= `Bridge`, `Move` 객체를 사용하여야 한다.

* __필드 종류__

> * 다리 건너기 게임 진행 상황 `HashMap<String, List<String>>`
> * 총 시도 횟수

* __메소드 종류__

> * 다리 건너기 `move()`
> > * 다리 건너기 게임 진행 상황 초기 세팅 `setBridgeGameResult()`
> > * O, X 구하기 `getPaintGame()`
> > * 다른 위치 구하기 `getOtherPosition()`
> > * 게임 결과 구하기 `paintBridgeGameResult()`
>
> * 재시작 `retry()`

### 다리 건너기 `move()`

실제 다리와 플레이어의 다리를 비교해서, 동일한 위치에 같은 값을 가지면 O를 표시하고 움직인다.
서로 다른 값이면 X를 표시하고 단일 게임이 종료된다.
> 1. `Bridge` 객체 둘을 서로 비교한다.
> 2. 비교한 값이 일치하면(`U-U` 또는 `D-D`) O, 아니면 X를 저장한다.
> 3. X가 저장될 경우에 `retry()` 메소드를 호출한다.

### 재시작 `retry()`

> 1. `Move`의 값을 비교해서 `R`이면 `move()` 메소드를 호출한다.

