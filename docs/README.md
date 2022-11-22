# java-bridge

## 요구 사항
- 2행 n열의 다리가 있다. ( n은 사용자 입력 )
- 각 칸마다 위/아래 중 하나만 건널 수 있는 칸에 해당
  - 다리를 생성할 때 무작위로 설정 
- 사용자 입력으로 위/아래 선택 가능
  - 위 : U 입력
  - 아래 : D 입력
  - 매 시행마다 결과 출력
  - 실패하면 다시 시작할 지 입력받기
  - 성공하면 다음 시행 입력받기
  - 최종 성공 시 다시 시작할 시 입력받기
- 예외 상황 시 에러 문구 출력 후 
  - `IllegalArgumentException` 발생
- ***해당 부분부터 다시 입력받기***

## Application 클래스
- BridgeGame 클래스로부터 게임 시작을 요청하는 클래스

### 세부 기능 : 
- `BridgeGame` 클래스 객체를 생성한 다음 
- 게임을 시작하는 메서드를 호출

## BridgeGame 클래스
- 하나의 전체 게임을 수행하는 클래스
- 아래의 세부적인 기능들을 하는 클래스들을 멤버변수로 가지며
  - ( `BridgeGame`에 필드(인스턴스)를 추가 가능 )
- 각 클래스 객체들에게 특정 작업을 위해 함수를 호출할 예정

### 세부 기능 :
- `Application` 클래스에서 호출할 하나의 게임 사이클 함수
- 

## BridgeMaker 클래스
- 게임 시작 시 사용자의 입력을 받아 해당 길이만큼 가진 다리를 생성
- `BridgeMaker`의 필드(인스턴스 변수)를 변경 불가
- `BridgeMaker`의 시그니처(인자, 이름)와 반환 타입은 변경 불가

### 세부 기능 
- `makeBridge` 함수( 함수명 지정 ) : 다리를 생성하는 함수
  - 각 인덱스마다의 구성 요소 : `String` ( 문자열 )
  - 각 문자열의 
    - 0번째 문자 : 위
    - 1번째 문자 : 아래
    - `BridgeRandomNumberGenerator` 생성 후
      - `generate()` 함수를 매 인덱스마다 생성하여
      - 위, 아래의 값을 문자 형태로 가진 다음 
      - 각 문자를 더한 문자열 형태로 저장

## BridgeNumberGenerator 인터페이스
- `BridgeRandomNumberGenerator` 클래스에서 구현해야 할 함수 정의
  - `int generate()` : 각 다리 칸을 위한 랜덤한 수 정의하는 함수
- 수정할 내용 없음

## BridgeRandomNumberGenerator 클래스
- `BridgeRandomNumberGenerator` 인터페이스를 상속(Implement)
- `int generate()` : 구현할 함수
  - 각 회차마다 랜덤으로 0 또는 1 반환

## InputView 클래스
- 다리 길이 입력 기능
- 한 게임 사이클 내 시도마다 이동할 칸 선택 입력 기능
- 성공/실패 등으로 게임 다시 시작 여부 입력받기


## OutputView 클래스
- 다리 건너기 시작 시 메세지 출력
- 이동할 칸 선택 후 결과 출력
- 최종 게임 결과 출력
- 게임 성공 여부 및 총 시도 횟수 출력