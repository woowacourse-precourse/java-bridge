# 다리 건너기 게임

## 기능 목록

### Business
#### BridgeGame

#### BridgeMaker

#### BridgeRandomNumberGenerator


### UI
#### InputView

#### OutputView


``
## 기능 요구 사항
- player 입력 요구사항 
  - 다리의 길이를 정할 3~20 사이의 정수를 입력한다.
  - 다리를 건너기 위해 U(위) , D(아래) 중 선택하여 입력한다.
  - 다리를 건너는 중 실패하면 재시작 여부를 위해 R(재시작) , Q(종료) 중 선택하여 입력한다.
  - 만약 잘 못 된 값을 입력하면 `[ERROR]`로 시작하는 에러메세지를 통해 문제 사항을 알려준 뒤 에러가 발생된 부분에서 부터 다시 시작한다.
  - 소문자도 잘 못 입력한 것으로 간주한다.


- 다리 생성 요구 사항
  - 다리 생성은 player가 입력한 길이만큼 생성이 되며 다리는 위 아래 두 칸으로 이루어진다.
  - 다리는 List< String > 로 생성한다.
  - 다리는 위 아래 칸 중 한 개만 건널 수 있는 다리이며 위로 갈 수 있으면 U, 아래이면 D이다.


- 게임 진행 요구 사항
  - player는 다리를 건널 때 실패를 하게 된다면 재시작 여부를 확인할 수 있으며 재시작을 하게 된다면 동일한 다리에서 처음부터 게임을 시작한다.
  - player가 한 칸의 다리를 건넜다면 현재 다리의 형태를 print 한다.
  - player가 모든 다리를 건너는데 성공 혹은 포기 했다면 게임 성공 여부를 띄우고 총 시도한 횟 수를 띄어준다.
  - 총 시도한 횟 수는 시작 횟 수 이다.


- 제공되는 `InputView`, `OutputView`, `BridgeGame`, `BridgeMaker`, `BridgeRandomNumberGenerator` 를 사용해야 한다.
- 사용자 입력 요청은 `InputView`에서만 가능하다.


## 구현 제한 사항
- else 예약어를 사용하지 않는다.
- Business 로직과 UI 로직은 분리 되어야 한다.
- 함수의 길이는 10라인을 넘기지 않는다. (줄 공백 포함)
- 함수의 파라미터는 3개까지만 허용한다.
- `OutputView`,`BridgeGame`의 함수 이름은 변경이 불가능 하다.
- `BridgeMaker`의 필드(인스턴스 변수)를 변경할 수 없으며 함수의 파라미터, 반환 값을 변경할 수 없다.
- `BridgeRandomNumberGenerator`, `BridgeNumberGenerator` 클래스의 코드는 변경이 불가능 하다.
- 

## 특이사항
