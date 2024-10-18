package pkg;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

/**
 * 자바독
 * 데이터베이스 연결을 관리하는 싱글톤 클래스입니다.
 *
 *
 *
 * @created 2024-10-14
 * @lastModified 2024...??
 * @changelog <ul>
 * <li>2024-10-14: 최초 생성 (Kim Sin Ui)</li>
 *
 * ???
 * </ul>
 */

public class MainCalculator extends JFrame {
    private JTextField inputSpace; // 입력 필드
    private JTextArea area; // 히스토리 표시 영역
    // ... 기존 코드 유지 ...

     /**
     * 데이터베이스 연결을 가져옵니다.
     *
     * @return 데이터베이스 연결 객체
     * @throws SQLException 데이터베이스 연결 중 오류가 발생한 경우
     * @created 2024-10-14
     * @lastModified ???
     * @changelog <ul>
     * <li>2024-10-14: 최초 생성 (Kim Sin Ui)</li>
     * ???
     * <li>2024-09-29: 연결 타임아웃 처리 추가 (Nam Su Man)</li>
     * </ul>
     */

    MainCalculator() {
        setTitle("계산기"); // 타이틀을 계산기로 지정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 클릭시 종료
        setSize(250, 300);  // 계산기의 크기 지정

        panelWindow(); // 입출력 값을 보여주는 창이 있는 패널
        panelButton(); // 숫자와 사칙 연산 버튼이 있는 패널

        setVisible(true);

    }

    private void panelWindow() {
        JPanel Panel = new JPanel();
        Panel.setLayout(new BorderLayout());
        inputSpace = new JTextField();
        inputSpace.setEditable(false); // 편집 불가능하게 설정
        inputSpace.setBackground(Color.LIGHT_GRAY); //배경색 그레이로 설정
        inputSpace.setHorizontalAlignment(JTextField.LEFT);
        inputSpace.setBounds(8, 55, 220, 50); // x:8 y:10 위치, 220*50 크기로 설정
        Panel.add(inputSpace);
        add(Panel);
    }
//gridBackLayout


    private void panelButton() {

        JPanel ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new GridLayout(4, 3, 10, 10));
        ButtonPanel.setBounds(8, 115, 230, 235);

        String[] button_names = {"7", "8", "9", "÷", "4", "5", "6", "×", "1", "2", "3", "-", "C", "0", "=", "+"}; //계산기 버튼 글자 배열
        JButton[] buttons = new JButton[button_names.length]; //버튼 배열

        //        버튼 생성
        for (int i = 0; i < button_names.length; i++) {
            buttons[i] = new JButton(button_names[i]);
            buttons[i].setFont(new Font("나눔고딕", Font.BOLD, 20));
            ButtonPanel.add(buttons[i]);
        }

        add(ButtonPanel, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        new MainCalculator();
    }
}

