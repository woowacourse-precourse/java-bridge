## 기능 요구사항

### 프로그램 기능 조건

- 다리 조건
  - 위아래 두 칸으로 이루어진 다리는 왼쪽 -> 오른쪽으로 건너야 한다.
  - 위아래 둘 중 하나의 칸만 건널 수 있다.
  - 다리의 길이는 숫자로 입력 받는다.
- 다리 이동
  - 다리를 생성할 때 건널 수 있는 칸은 무작위 값으로 정한다.
  - 위 칸을 건널 수 있으면 U, 아래 칸 건널 수 있으면 D
  - 무작위 값이 0이면 아래, 1인 경우 위 칸을 건널 수 있는 칸
  - 다리가 생성되면 플레이어가 이동할 칸 선택
  - 이동할 때 위 칸은 '대문자' U, 아래 칸은 '대문자' D
  - 이동할 칸을 건널 수 있다면 O, 없으면 X
- 게임 종료
  - 다리를 끝까지 건너면 게임 종료
  - 다리를 건너다 실패하면 게임 재시작 or 종료
  - 재시작해도 처음에 만든 다리를 재사용
  - 게임 결과의 총 시도 횟수는 첫 시도를 포함해 게임을 종료할 때까지 시도한 횟수
- 에러 처리
  - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생
  - 에러 메시지는 "[ERROR]"로 시작하는 에러 메시지 출력 후 다시 입력 받기
  - IllegalArgumentException, IllegalStateException 같은 명확한 유형 처리하기
### 입력 구현 사항
- [X] 자동으로 생성할 다리 길이 입력 (3 <= x <= 20)
- [X] 라운드마다 플레이어가 이동할 칸 입력 (U, D만 가능)
- [X] 게임 재시작/종료 여부를 입력 (R, Q만 가능)
### 입력 Exception 구현 사항
- [X] 다리 길이가 입력되지 않은 경우 IllegalArgumentException
- [X] 다리 길이가 숫자가 아닌 경우 IllegalArgumentException
- [X] 다리 길이가 3보다 작거나, 20보다 큰 경우 IllegalArgumentException
- [X] 플레이어가 이동할 칸이 입력되지 않은 경우 IllegalArgumentException
- [X] 플레이어가 이동할 칸이 U, D가 아닌 경우 IllegalArgumentException
- [X] 게임 재시작/종료 여부가 입력되지 않은 경우 IllegalArgumentException
- [X] 게임 재시작/종료 여부가 R, Q가 아닌 경우 IllegalArgumentException
### 출력 구현 사항
- [X] 게임 시작 문구 출력
- [X] 게임 종료 문구 출력
- [X] 다리 건너기 결과 출력
  - [X] 이동할 수 있는 칸 선택 : O 표시 출력
  - [X] 이동할 수 없는 칸 선택 : X 표시 출력
  - [X] 선택할 수 없는 칸 선택 : 공백 출력
  - [X] 다리의 시작은 `[`, 다리의 끝은 `]`으로 표시
  - [X] 다리 칸의 구분은 `|` 문자열로 구분 (앞뒤 공백 포함)
  - [X] 현재까지 건넌 다리 모두 출력
### BridgeGame 구현 사항
- [X] 사용자가 칸을 이동하는 기능
- [X] 게임 재시작 기능
- [X] 게임 종료 기능
- [X] 게임 초기화 기능
- [X] 총 시도한 횟수 세기
- [X] 게임 성공 여부 확인
### BridgeMaker
- [X] 주어진 길이의 다리를 무작위로 생성하는 기능
### Bridge
- [X] 사용자 입력에 따라 다리를 이동할 수 있는지 확인하는 기능
## 프로그래밍 요구사항
- indent depth 2까지 허용
- 3항 연산자 쓰지 않기
- 함수가 한 가지 일만 하도록 최대한 작게 만들기
- else 예약어 쓰지 않기
- 도메인 로직 단위 테스트 구현
- 함수의 길이가 10라인을 넘어가지 않도록 구현
- 메서드의 파라미터 개수는 최대 3개까지만 허용
- InputView 클래스에서만 readLine() 메소드를 이용해 입력을 받을 수 있도록 구현
- BridgeGame 클래스에서 InputView, OutputView 사용하지 않기
### InputView 클래스
- InputView 패키지 변경 가능
- InputView 메서드 시그니처와 반환 타입 변경 가능
- 사용자 값 입력을 위한 메서드 추가 가능
### OutputView 클래스
- OutputView 패키지 변경 가능
- OutputView 메서드 이름은 변경 불가, 인자/반환 타입은 추가/변경 가능
- 값 출력을 위한 메서드 추가 가능
### BridgeGame 클래스
- BridgeGame 필드 추가 가능
- BridgeGame 패키지 변경 가능
- BridgeGame 메서드 이름 변경 불가, 인자/반환 타입은 추가/변경 가능
- 게임 진행을 위한 메서드 추가하거나 변경 가능
### BridgeMaker 클래스
- BridgeMaker 필드 변경 불가
- BridgeMaker 메서드 시그니처, 반환 타입 변경 불가
### BridgeRandomNumberGenerator 클래스
- Random 값 추출은 bridge.BridgeRandomNumberGenerator의 generate() 활용
- BridgeRandomNumberGenerator, BridgeNumberGenerator 클래스의 코드 변경 불가
