# 💻 프로그램 동작 방식

---

#### 1. 사용자로부터 `InputView`에서 값을 입력 받고 초기화 후, 게임을 실행한다.
#### 2. `InputView`에서 값을 입력 받는다.
#### 3. `Validator`를 통해 입력값을 검증한다.
#### 4. 예외 발생시 재입력받는다.
#### 5. 예외가 발생하지 않을 경우, `Application`에 값을 반환한다.
#### 6. `BridgeGame`에 해당 값을 넘겨주어 update한다.
#### 7. update된 `BridgeGame`을 `Application`에서 `OutputView`로 넘겨준다.
#### 8. 해당 값을 활용해 출력한다.
#### 9. 게임이 종료될 때 까지 2~8를 반복한다.


# 🧰 기능 목록

---

### 1. 게임 시작 문구를 출력한다. - `View`/`InputView`

### 2. 다리의 길이를 숫자를 입력받고 생성한다.
   - [x] 입력받은 숫자(문자열)을 정수로 변환한다. - `Domain`/`InputConverter`
      - [x] 숫자가 아닌 입력일 경우(문자, 빈 문자열) 예외를 던진다. - `Domain`/`InputValidator`
      - [x] 잘못된 입력일 경우, 올바른 입력이 될 때 까지 입력받는다. - from `Application` call `View`/`InputView`
   - [x] 입력받은 숫자가 3 이상 20 이하인지 확인하고 아니면 예외를 던진다. - `Domain`/`InputValidator`
   - [x] 0과 1을 다리 길이만큼 무작위로 생성한다. - `BridgeMaker` from `BridgeRandomNumberGenerator`
   - [x] 0인 경우 아랫 칸인 `D`, 1인 경우 윗 칸인 `U`인 다리 리스트를 만든다. - from `Domain`/`Bridge` call `BridgeMaker`
### 3.`U` 또는 `D`를 입력받아 이동할 칸을 선택한다. `View`/`InputView`
   - [x] 정해진 문자가 아니거나 입력이 없으면 예외를 던진다. - `Domain`/`InputValidator`
   - [x] 예외가 발생할 경우, 다시 입력받도록 한다. - from `Application` call `View`/`InputView`
   - [x] 이동 후 생사여부를 update한다 - in `Domain`/`BridgeGame` update `Domain`/`Player` 

### 4. 입력 결과를 출력한다.
  - [X] 건너온 칸들은 전부 O로 출력하고 칸 일치여부와 생사여부에 따라 O, X를 출력을 결정한다. - from `Application` call `View`/`OutputView`

### 5. 생사여부를 판별 후, 다음 행동을 결정한다.
  #### 5-1. 죽었을 때
   - [x] 건너다 실패하면 재시작 `R`, 종료 `Q` 할 수 있다. `View`/`InputView`
   - [x] 정해진 문자가 아니거나 입력이 없으면 예외를 던진다 `Domain`/`InputValidator`
   - [x] 예외가 발생할 경우, 다시 입력받도록 한다. from `Application` call `View`/`InputView`
   - [x] 재시작시 처음부터 다시 진행한다. - `Application`

  #### 5-2. 살았을 때
- [x] 끝에 도달할 때 까지 계속 진행한다. - `Application`


### 6. 게임 종료시 결과를 출력한다. `OutputView`/`printResult`
  - [x] 최고 기록을 출력한다. 
  - [x] 게임 성공 여부를 출력한다.
  - [x] 총 시도 횟수를 출력한다.

   



# 🛠️ 클래스 설계

---

## BridgeMaker
```
    - Bridge를 랜덤한 길이로 생성
```

## Constant

---

- ### InputValue
```
  - 사용자 입력값으로 이루어진 상수 클래스
```

- ### OutputValue
```
  - 출력값으로 이루어진 상수 클래스
```


## Util

---

- ### InputConverter
```
  - 사용자가 입력한 값(문자열)을 정수로 변환해 return
  - 변환 불가시 예외를 던짐
```

- ### InputValidator
```
    - 입력값에 대한 검증
    - 올바르지 않은 입력일 시 예외를 던짐
```


## Model

---

- ### Bridge
```
    - 게임에 사용되는 다리 정보
```

- ### BridgeBlock
```
    - 사용자 선택 정보를 열거형 상수로 지정한 enum 클래스
```

- ### Player
```
    - 현재 위치
    - 생사 여부
```

- ### BridgeGame
```
    - 게임 상태 및 제어에 관련된 클래스
    - 주어진 값에 대한 검증
    - 개수를 입력받고 Bridge 모델 초기화
    - 입력값에 따라 유저의 생사 여부 및 위치 결정
    - 최고 기록을 저장
```


## View

---

- ### InputView
```
    - 게임 시작 문구 출력
    - 입력 문구 출력
    - 입력받은 값을 검증 후 반환
```
### OutputView
```
    - 결과 문구 출력
    - update된 정보를 가공하여 출력
```



# ❗ 주의사항 체크 리스트

---

- [x] `Exception`이 아닌 `IllegalArgumentException`과 같이 명확하게 유형을 처리하였는가?
- [x] 입출력 요구 사항을 모두 지켰는가?
  - [x] 게임 시작 문구
  - [x] 길이 입력 문구
  - [x] 칸 입력 문구
  - [x] 칸 입력 후 다리 상태
  - [x] 실패했을 시 재시도, 종료 여부
  - [x] 게임 성공 여부 및 시도 횟수
- [x] 함수(또는 메소드)의 길이가 10라인 이내인가? (빈줄 포함)
- [x] 함수(또는 메소드)의 파라미터가 3개 이하인가?
- [x] 클래스 제약 사항들을 모두 지켰는가?
  - [x] `OutuptView`의 메소드 이름을 변경하면 안된다. (printMap, printResult)
  - [x] `BridgeMaker`의 메소드의 시그니처(인자, 이름)와 반환 타입을 변경하면 안된다.
  - [x] `BridgeGame`의 메소드 이름을 변경하면 안된다. (move, retry)
  - [x] `InputView` 클래스에서만 `readLine()`을 사용한다. 
  - [x] `BridgeRandomNumberGenerator`, `BridgeNumberGenerator`의 를 수정하면 안된다.
  - [x] `BridgeRandomNumberGenerator`, `BridgeNumberGenerator`의 패키지를 수정하면 안된다.
