package pkg;

import javax.swing.*;

public class MainCalculator extends JFrame {
    private JTextField inputSpace; // 입력 필드
    private JTextArea area; // 히스토리 표시 영역

    MainCalculator(){
        inputSpace = new JTextField();
        area = new JTextArea();

        setTitle("계산기"); // 타이틀을 계산기로 지정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 클릭시 종료
        setSize(250, 300);  // 계산기의 크기 지정
        setVisible(true); // 창을 화면에 보이게 함.

        panelWindow(); // 입출력 값을 보여주는 창이 있는 패널
        panelButton(); // 숫자와 사칙 연산 버튼이 있는 패널


    }

    private void panelWindow() {
    }





    private void panelButton() {
    }

    public static void main(String[] args) {
    new MainCalculator();
    }
}
