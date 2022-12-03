# 자바 - 브릿지

### View Package
#### InputView
> **제한사항**
>+ 제공된 `InputView` 클래스를 활용해 구현해야 한다.
>+ `InputView`와 패키지는 변경할 수 있다.
>+ `InputView`의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
>+ 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
>+ `InputView`에서만 `readLine()`메서드를 이용해 사용자의 입력을 받을 수 있다.

+ 기능 목록
  + [X] 다리의 길이 입력
    + [X] 3 이상 20 이하의 숫자를 입력.
    + [X] 올바른 값이 아닐 경우 예외 처리(`IllegalArgumentException`)
      + [X] 정수가 입력되지 않은 경우
  + [X] 이동할 칸 입력
    + [X] 올바른 값이 아닐 경우 예외 처리(`IllegalArgumentException`)
      + [X] 길이가 1인 문자열이 아닌 경우
  + [X] 게임 재시작 여부 입력
    + [X] 올바른 값이 아닐 경우 예외 처리(`IllegalArgumentException`)
      + [X] 길이가 1인 문자열이 아닌 경우

#### OutputView
> **제한사항**
>+ 제공된 `OutputView` 클래스를 활용해 구현해야 한다.
>+ `OutputView`의 패키지는 변경할 수 있다.
>+ `OutputView`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
>+ 값 출력을 위해 필요한 메서드를 추가할 수 있다.

+ [X] 기능 목록 
  + [X] 다리 건너기 게임 시작 메시지 출력
  + [X] (게임 시작 시) 다리 길이 입력 메시지 출력
  + [X] (매 라운드) 이동할 칸 선택 입력 메시지 출력
  + [X] (매 라운드) 게임의 지도 출력 
    + [X] 다리의 시작은 '[', 다리의 끝은 ']'로 표시 
    + [X] 건널 수 있는 칸일 경우 'O', 건널 수 없는 칸일 경우 'X', 빈 칸의 경우 ' '로 표시
    + [X] 각 다리의 칸은 '|'(앞뒤 공백 포함)으로 구분 
    + [X] 현재까지 건넌 다리를 모두 출력
  + [X] (클리어 실패 시) 게임 재시도 여부 입력 메시지 출력
  + [X] (게임 종료 시) 게임의 결과 출력
    + [X] 게임 성공 여부 출력
    + [X] 총 시도 횟수 출력
  + [X] 예외 발생 시 에러 메시지를 출력
    + [X] 에러문구는 "[ERROR]"로 시작해야 한다.
- - -

### Domain Package
#### BridgeGame
> **제한사항**
>+ 제공된 `BridgeGame` 클래스를 활용해 구현해야 한다.
>+ `BridgeGame`에 필드를 추가할 수 있다.
>+ `BridgeGame`의 패키지는 변경할 수 있다.
>+ `BridgeGame`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
>+ 게임 진행을 위해 필요한 메서드 추가하거나 변경할 수 있다.

+ [X] 기능 목록 
  + [X] `BridgeMaker`를 통해 생성된 다리를 이용
  + [X] 주어진 입력에 따라 다음 칸으로 갈 수 있는지 여부를 판정
    + [X] 주어진 입력이 'U', 'D'가 아닌 경우 예외 처리
  + [X] 게임의 성공, 실패 여부를 판정
  + [X] 재시작 기능
    + [X] 게임 실패 시 입력 받은 재시작 여부를 통해 게임을 재시작할지를 판정
    + [X] 주어진 입력이 'R', 'Q'가 아닌 경우 예외 처리
    + [X] 재시작 시 새로 다리를 만들지 않고 처음부터 시작.
- - -
### BridgeMaker
> **제한사항**
>+ 제공된 `BridgeMaker` 클래스를 활용해 구현해야 한다.
>+ `BridgeMaker` 의 필드를 변경할 수 없다.
>+ `BridgeMaker` 의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.

+ [X] 기능 목록
  + [X] 주어진 길이에 맞게 "U"와 "D"로 이루어진 무작위 배열을 만들어 반환
    + [X] `BridgeRandomNumberGenerator`의 `generate()`를 통해 반환된 정수를 `String`으로 변환
    + [X] 주어진 다리의 길이가 3미만, 20초과인 경우 예외 처리

### BridgeRandomNumberGenerator
> **제한사항**
>+ Random 값 추출은 제공된 `bridge.BridgeRanomNumbeGenerator`의 `generate()`를 활용한다.
>+ `BridgeRandomNumberGenerator`, `BridgeNumberGenerator` 클래스의 코드는 변경할 수 없다.

- - -

### Controller Package
#### Controller
+ [X] 기능 목록
  + [X] 게임 시작
  + [X] 다리의 길이 입력
    + [X] OutputView) 입력 요청 메시지 출력
    + [X] InputView) 입력을 받음
    + [X] BridgeMaker) 입력 받은 길이의 다리를 만듦.
    + [X] 만들어진 다리를 BridgeGame으로 건넴
  + [X] 이동할 칸 선택
    + [X] OutputView) 입력 요청 메시지 출력
    + [X] InputView) 입력 받음
    + [X] 입력을 BridgeGame으로 건넴
    + [X] BridgeGame) 현재 진행 상황을 받아오기
    + [X] OutputView) 현재 진행 상황을 출력
  + [X] (실패 시)게임 재시도 여부 확인
    + [X] OutputView) 입력 요청 메시지 출력
    + [X] InputView) 입력 받음
    + [X] 입력을 BridgeGame으로 건넴
  + [X] (게임 종료 시) 최종 결과 확인
    + [X] BridgeGame) 게임 성공 여부와 총 시도 횟수 받음
    + [X] OutputView) 최종 결과 출력
  + [X] 잘못된 입력을 받았을 경우 에러 메시지를 출력 해당 자리에서 재입력
