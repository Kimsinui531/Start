package pkg;

import javax.swing.*;
import java.awt.*;

/**
 * 자바독
 * 데이터베이스 연결을 관리하는 싱글톤 클래스입니다.
 *
 * @created 2024-10-14
 * @lastModified 2024...??
 * @changelog <ul>
 * <li>2024-10-14: 최초 생성 (Kim Sin Ui)</li>
 * </ul>
 */

public class MainCalculator extends JFrame {
    private JTextField inputSpace; // 입력 필드

    MainCalculator() {
        setTitle("계산기"); // 타이틀을 계산기로 지정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 클릭시 종료
        setSize(350, 520); // 계산기의 크기 지정

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // NORTH 패널 설정
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 4.0; // 비율 4
        gbc.fill = GridBagConstraints.BOTH;
        add(panelExpression(), gbc);

        // CENTER 패널 설정
        gbc.gridy = 1;
        gbc.weighty = 3.0; // 비율 3
        add(panelWindow(), gbc);

        // SOUTH 패널 설정
        gbc.gridy = 2;
        gbc.weighty = 3.0; // 비율 3
        add(panelButton(), gbc);

        setVisible(true);
    }

    private JPanel panelExpression() {
        JPanel expressionPanel = new JPanel();
        inputSpace = new JTextField();
        inputSpace.setBackground(new Color(10,10,40));
        inputSpace.setForeground(Color.WHITE);
        expressionPanel.add(inputSpace);
        return expressionPanel;
    }

    private JPanel panelWindow() { // 계산 결과값을 출력해주는 패널
        JPanel windowPanel = new JPanel();

        windowPanel.setLayout(new BorderLayout());
        JTextField ResultSpace = new JTextField();
        ResultSpace.setEditable(false); // 편집 불가능하게 설정
        ResultSpace.setBackground(new Color(40, 40, 40)); // 배경색 그레이로 설정
        ResultSpace.setHorizontalAlignment(JTextField.LEFT);
        ResultSpace.setForeground(Color.white);
        windowPanel.add(ResultSpace);
        return windowPanel;
    }

    private JPanel panelButton() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        String[] button_names = {"7", "8", "9", "÷", "4", "5", "6", "×", "1", "2", "3", "-", "C", "0", "=", "+"}; // 계산기 버튼 글자 배열
        JButton[] buttons = new JButton[button_names.length]; // 버튼 배열

        // 버튼 생성 색 지정
        for (int i = 0; i < button_names.length; i++) {
            buttons[i] = new JButton(button_names[i]);
            buttons[i].setFont(new Font("나눔고딕", Font.BOLD, 20));
            buttons[i].setBackground(Color.LIGHT_GRAY);
            if (button_names[i].equals("C")) {
                buttons[i].setBackground(new Color(255, 192, 203));
            }
            if ("÷×-+".contains(button_names[i])) {
                buttons[i].setBackground(new Color(245, 222, 179));
            }
            if (button_names[i].equals("=")) {
                buttons[i].setBackground(new Color(240, 110, 140));
            }
            buttons[i].setForeground(Color.WHITE);
            buttonPanel.add(buttons[i]);
        }

        return buttonPanel;
    }

    public static void main(String[] args) {
        new MainCalculator();
    }
}

