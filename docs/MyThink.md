# 🤔 My Think

## 목표
어떻게든 내가 생각한 것들을 주절주절 적어보자

- commit 내역 합치는 방법 배움 fixup
- class의 변수
  - public final v
    - 변수: 메소드 정의 가능, 메소드 재정의 불가
    - 객체: 메소드 정의 가능, 메소드 재정의 불가
    </br>  메소드에서 값 변경 가능?
  - public static final v
    - 변수: 메소드 정의 불가, 메소드 재정의 불가
    - 객체: 메소드 정의 불가, 메소드 재정의 불가
    </br>  메소드에서 값 변경 가능?
  - static으로 설정하는 것보다 final 설정이 더 중요해 보여서 final로 결정

- loop 안에서 string += 는 나쁜 코드
  - array copy와 garbage를 남발하는 행동
  - StringBuilder result = new StringBuilder("[ ");
  - result.append(string); 을 사용
  - 이 때, append 안에서 + 쓰지않기