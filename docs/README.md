# 🚀 기능 요구 사항 정리

### ❗ 체크 사항은 구현해야할 요소

<hr>

## 시나리오 실행

- [ ] Application에서 BridgeScenario를 생성하여 전체 프로그램 흐름을 제어
    - BridgeScenario에서 입출력 호출

- [ ] 예외에 따라 재시도 로직 구현

<br/>

<hr>

### 다리 게임 객체 BridgeGame

- 수정 가능 사항:
    - 필드, 패키지, 파라미터, 반환 타입

- 제약 사항
    - `InputView`, `OutputView` 사용 금지

- 메소드 추가 가능 여부: O

- [x] 위아래 중 하나로 이동 move()
    - 이동 할 때 마다 진행 상태 오른쪽에 이동 한 위치(위, 아래)에 O, X 기록
    - move의 결과가 X일 경우 현재 상태 BridgeStatus를 STOP으로 변경
    - [x] 검증
        - BridgeStatus RUNNING인 경우만 가능
            - [x] 해당 상태가 아닐 경우 IllegalStateException 처리
        - 입력된 값이 U 또는 D 검사
            - [x] 해당 값이 아닐 경우 IllegalArgumentException 처리
        - 현재 Bridge 위아래 size가 일치 하는지 검사
            - [x] 해당 상태가 아닐 경우 IllegalStateException 처리


- [ ] 재시도 retry()
    - 현재 진행 상태 초기화
    - 초기화 후 시도 횟수 + 1
    - [ ] 검증
        - BridgeStatus STOP인 경우만 가능
            - [ ] 해당 상태가 아닐 경우 IllegalStateException 처리
        - 입력된 값이 R 또는 Q 검사
            - [ ] 해당 값이 아닐 경우 IllegalArgumentException 처리


- [x] 현재 상태 종류 반환 status()


- [x] 현재 다리 진행도 반환 progress()


- [ ] 현재 총 시도 횟수 반환 tryTimes()

<br/>

### 다리 게임 상태 Enum BridgeStatus

- [x] 진행 중 RUNNING
- [x] 진행 불가 STOP
- [x] 진행 완료 FINISH

<br/>

### 다리 생성기 BridgeMaker

- 수정 가능 사항
    - 메소드 내 로직

- 메소드 추가 가능 여부: X


- [x] size만큼 Bridge 생성 makeBridge(int size)
    - [x] 검증
        - 입력된 값이 3 ~ 20 범위의 숫자
        - [x] 해당 범위가 아닐 경우 IllegalArgumentException 처리

<br/>

### 다리 정답 난수 생성기 BridgeRandomNumberGenerator

- 수정 가능 사항: X
- 메소드 추가 가능 여부: X


- 0, 1 생성기 generate()

<br/>

<hr>

## 화면 입출력 View

### 입력 시 출력 InputView

- 수정 가능 사항
    - 패키지, 메소드 파라미터, 메소드 반환 타입

- 메소드 추가 가능 여부: O


- 다리 길이 입력 readBridgeSize()
    - [x] 텍스트 출력
      ```
      다리의 길이를 입력해주세요.
      ```
    - [x] 검증 사항
        - Integer.parseInt로 변환 되는 수
        - 해당 범위가 아닐 경우 예외 처리
            - [x] IllegalArgumentException 처리


- 이동 칸 방향 입력 readMoving()
    - [x] 텍스트 출력
      ```
      이동할 칸을 선택해주세요. (위: U, 아래: D)
      ```
    - [x] 검증 사항
        - U 또는 D
        - 해당 범위가 아닐 경우 예외 처리
            - [x] IllegalArgumentException 처리


- 재시도/종료 입력 readGameCommand()
    - [x] 텍스트 출력
      ```
      게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)
      ```
    - [x] 검증 사항
        - R 또는 Q
        - 해당 범위가 아닐 경우 예외 처리
            - [x] IllegalArgumentException 처리

<br/>

### 입력 시 출력 OutputView

- 수정 가능 사항
    - 패키지, 메소드 파라미터, 메소드 반환 타입

- 메소드 추가 가능 여부: O


- [x] printStart()
  ```
  다리 건너기 게임을 시작합니다.
  ```

- [x] printMap()
  ```
  [ O | X ]
  [   |   ]
  ```

- [x]  printResult()
  ```
  게임 성공 여부: 실패
  총 시도한 횟수: 1
  ```

<br/>
    