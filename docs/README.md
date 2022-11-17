## 🚀 기능 목록
- ## 컨트롤러
  - [ ] 다리 건너기 게임 컨트롤러
- ## 모델
  - ### 데이터
    - DTO
      - RequestDto
        - [ ] 게임 초기화 명령어 DTO
        - [ ] 게임 진행 명령어 DTO
        - [ ] 실패 메뉴 명령어 DTO
      - ResponseDto
        - [ ] 게임 진행 상황 DTO
        - [ ] 게임 최종 결과 DTO
  - ### 서비스
    - [ ] 다리 제작
    - [ ] 다리 건너기 게임
- ## 뷰
  - ### 입력
    - [ ] `3 ~ 20` 다리 길이
    - [ ] `U` or `D` 이동할 칸
    - [ ] `R` or `Q` 재시작/종료 여부
  - ### 출력
    - [ ] 게임 시작 문구
    - [ ] 게임 종료 문구
      - [ ] 지도
      - [ ] 성공 여부
      - [ ] 시도 횟수
    - [ ] 에러 문구
- ## 타입
  - [ ] 게임 일반 상수 타입
  - [ ] 게임 상태 타입 (INIT, PLAY, FAIL, DONE)
  - [ ] 진행 명령어 타입
  - [ ] 메뉴 명령어 타입

## ✏ 과제를 진행하며 배운 점
- IllegalArgumentException 과 IllegalStateException은 어떤 상황에 발생시키 오류인가?[[참조](https://stackoverflow.com/questions/20169127/what-is-illegalstateexception)]
  - IllegalStateException 이란?
    - 메서드가 호출 되면 안되는 때에 호출 됐을 때 발생시키는 런타임 익셉션의 한 종류.
    - 실행 중에 일어날 수 없는 일을 일으키려 할 때 발생 시키는 것이다.
    ```java
    public class Game {
      private boolean isFinished;
      
      public Game() {
      isFinished = false;
      }  
    
      public void terminate() {
          if (isFinished == true) {
              throw new IllegalStateException("게임이 이미 종료되었습니다.");
          }
          this.isFinished = true;
      }
    
      public static void main(String[] args) {
          Game game = new Game();
          game.terminate();
          game.terminate();
        }
    }
    ```
  - IllegalArgumentException 이란?
    - 잘못된 인자값이 주어졌을 때 발생시키는 런타임 익셉션의 한 종류.
    - 들어온 인자값의 타입은 맞는데, 값이 이상할 때(범위 문제나 포맷 문제, Null 문제 등) 발생 시키는 것이다.
    ```java
    public class Person {
      private int age;

      public void setAge(int age) {
          if (age < 0) {
              throw new IllegalArgumentException("나이는 0보다 커야합니다.");
          }
          this.age = age;
      }
    
      public static void main(String[] args) {
          Person person = new Person();
          person.setAge(-1);
        }
    }
    ```
