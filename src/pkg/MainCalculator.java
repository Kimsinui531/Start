package pkg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

/**
 * MainCalculator 클래스
 * <p>
 * 이 클래스는 간단한 GUI 계산기를 구현
 * 사용자가 입력한 숫자와 연산자를 통해 결과를 계산, 계산 과정을 표시하는 기능을 제공
 * 계산기 UI는 Swing 라이브러리를 사용하여 구현
 * </p>
 *
 * <p>
 * <strong>예외 처리:</strong> 나누기 연산에서 0으로 나누는 경우를 처리하지 않음
 * </p>
 *
 * @created 2024-10-14
 * @lastModified 2024-10-20
 * @changelog <ul>
 * <li>2024-10-14: 최초 생성 (Kim Sin Ui)</li>
 * <li>2024-10-14:계산기 외형을 위한 기본 골격 생성</li>
 * <li>2024-10-18:JPanel 추가 및 레이아웃 설정</li>
 * <li>2024-10-18:버튼 이름 추가 및 JButton 인스턴스 초기화</li>
 * <li>2024-10-19:계산기 UI 개선: 배경 색상 수정 및 레이아웃 변경</li>
 * <li>2024-10-19:버튼 클릭 리스너 및 계산 메서드 구현</li>
 * <li>2024-10-20:추가된 기능 및 코드 수정</li>
 * <li>2024-10-20: 자바독 추가</li>
 * <li>2024-10-29: 계산기 버튼 및 기능 추가</>
 * </ul>
 */


public class MainCalculator extends JFrame {

    private JTextArea expressionArea; // 계산 과정을 저장할 JTextArea
    private JTextField inputSpace; // 사용자 입력
    private String operator = "";
    private BigDecimal firstNumber = null;

    /**
     * MainCalculator 생성자
     * <p>
     * 계산기 UI를 초기화하고 패널을 설정
     * GridBagLayout을 사용하여 동적인 레이아웃을 구성하여 계산기 버튼과 표시 영역을 포함
     * </p>
     */

    MainCalculator() {
        setTitle("계산기"); // 타이틀을 계산기로 지정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 클릭시 종료
        setSize(350, 520); // 계산기의 크기 지정

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // NORTH 패널 설정
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0; // 비율 1
        gbc.fill = GridBagConstraints.BOTH;
        add(panelExpression(), gbc);

        // SOUTH 패널 설정
        gbc.gridy = 1;
        gbc.weighty = 3.0; // 비율 3
        add(panelButton(), gbc);

        setVisible(true);
    }
    /**
     * 계산 과정과 사용자 입력을 위한 패널 생성
     * <p>
     * JTextArea와 JTextField를 포함하여 계산 과정을 표시
     * 사용자 입력을 처리
     * JScrollPane을 사용하여 텍스트 영역의 스크롤을 가능하게 함
     * </p>
     *
     * @return 설정된 JPanel
     */

    private JPanel panelExpression() {
        JPanel expressionPanel = new JPanel(new BorderLayout());

        // JTextArea를 사용하여 계산 과정을 표시
        expressionArea = new JTextArea();
        expressionArea.setFont(new Font("나눔고딕", Font.BOLD, 18));
        expressionArea.setEditable(false);
        expressionArea.setBackground(new Color(10, 10, 40));
        expressionArea.setForeground(Color.WHITE);
        expressionArea.setLineWrap(true);
        expressionArea.setWrapStyleWord(true);

        inputSpace = new JTextField();
        inputSpace.setFont(new Font("나눔고딕", Font.BOLD, 24));
        inputSpace.setBackground(new Color(10,10,40));
        inputSpace.setForeground(Color.WHITE);

        expressionPanel.add(new JScrollPane(expressionArea), BorderLayout.CENTER); // 스크롤 가능하게 설정
        expressionPanel.add(inputSpace, BorderLayout.SOUTH);

        return expressionPanel;
    }

    /**
     * 계산기 버튼을 위한 패널 생성
     * <p>
     * 숫자 및 연산자 버튼을 포함하는 패널을 생성
     * 각 버튼은 ActionListener를 통해 클릭 이벤트를 처리
     * </p>
     *
     * @return 설정된 JPanel
     */


    private JPanel panelButton() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4));

        String[] button_names = {"%", "+/-", ".", "=", "7", "8", "9", "÷", "4", "5", "6", "×", "1", "2", "3", "-", "C", "0", "←", "+"}; // 계산기 버튼 글자 배열
        JButton[] buttons = new JButton[button_names.length]; // 버튼 배열

        // 버튼 생성 색 지정
        for (int i = 0; i < button_names.length; i++) {
            buttons[i] = new JButton(button_names[i]);
            buttons[i].setFont(new Font("나눔고딕", Font.BOLD, 20));
            buttons[i].setBackground(Color.LIGHT_GRAY);
            buttons[i].addActionListener(new ButtonClickListener());
            buttons[i].setForeground(Color.WHITE);

            if (button_names[i].equals("C")) {
                buttons[i].setBackground(new Color(255, 192, 203));
            }
            if (button_names[i].equals("←")) {
                buttons[i].setBackground(new Color(255, 192, 203));
            }
            if ("÷×-+".contains(button_names[i])) {
                buttons[i].setBackground(new Color(245, 222, 179));
            }
            if (button_names[i].equals("=")) {
                buttons[i].setBackground(new Color(240, 110, 140));
            }
            if ("%.".contains(button_names[i])) {
                buttons[i].setBackground(new Color(145, 192, 203));
            }
            if (button_names[i].equals("+/-")) {
                buttons[i].setBackground(new Color(145, 192, 203));
            }
            buttonPanel.add(buttons[i]);


        }

        return buttonPanel;
    }

    /**
     * 버튼 클릭 이벤트 리스너
     * <p>
     * 사용자가 버튼을 클릭했을 때 발생하는 이벤트를 처리
     * 숫자 입력, 연산자 설정, 결과 계산 등의 로직을 포함
     * </p>
     */

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if ("0123456789".contains(command)) {
                inputSpace.setText(inputSpace.getText() + command); // 숫자 추가
            } else if (command.equals("C")) {
                inputSpace.setText(""); // 초기화
                operator = "";
                firstNumber = null;
                expressionArea.setText("");// 이전계산기록 초기화
            } else if (command.equals("←")) { // 백스페이스 처리
                String currentText = inputSpace.getText();
                if (currentText.length() > 0) {
                    inputSpace.setText(currentText.substring(0, currentText.length() - 1));
                }
            } else if (command.equals("+/-")) { // 음수/양수 변환
                if (!inputSpace.getText().isEmpty()) {
                    BigDecimal currentValue = new BigDecimal(inputSpace.getText());
                    inputSpace.setText(currentValue.negate().toString());
                }
            } else if (command.equals(".")) { // 소수점 추가
                if (!inputSpace.getText().contains(".")) {
                    inputSpace.setText(inputSpace.getText() + ".");
                }
            } else if (command.equals("%")) { // 퍼센트 계산
                if (!inputSpace.getText().isEmpty()) {
                    BigDecimal currentValue = new BigDecimal(inputSpace.getText());
                    inputSpace.setText(currentValue.divide(BigDecimal.valueOf(100)).toString());
                }
            }else if (command.equals("=")) {
                if (firstNumber != null && !operator.isEmpty()) {
                    BigDecimal secondNumber = new BigDecimal(inputSpace.getText());
                    BigDecimal result = calculate(firstNumber, secondNumber, operator);
                    inputSpace.setText(result.toString());
                    expressionArea.append(firstNumber.toString() + " " + operator + " " + secondNumber.toString() + " = " + result.toString() + "\n");
                    firstNumber = null; // 계산 후 초기화
                    operator = "";
                }
            } else {
                if (firstNumber == null) {
                    firstNumber = new BigDecimal(inputSpace.getText());
                } else {
                    BigDecimal secondNumber = new BigDecimal(inputSpace.getText());
                    BigDecimal result = calculate(firstNumber, secondNumber, operator);
                    inputSpace.setText(result.toString());
                    //이전 계산 과정 기록
                    expressionArea.append(firstNumber.toString() + " " + operator + " " + secondNumber.toString() + " = " + result.toString() + "\n");
                }
                operator = command; // 연산자 설정
                inputSpace.setText(""); // 입력 필드 초기화
            }
        }
    }

    /**
     * 두 숫자와 연산자를 받아서 계산을 수행
     * <p>
     * 주어진 두 숫자와 연산자를 이용하여 계산 결과를 반환
     * </p>
     *
     * @param first    첫 번째 숫자
     * @param second   두 번째 숫자
     * @param operator 연산자
     * @return 계산 결과
     */

    private BigDecimal calculate(BigDecimal first, BigDecimal second, String operator) {
        switch (operator) {
            case "+":
                return first.add(second);
            case "-":
                return first.subtract(second);
            case "×":
                return first.multiply(second);
            case "÷":
                return first.divide(second);
            default:
                return BigDecimal.ZERO; // 기본값
        }
    }

    /**
     * 프로그램의 진입점
     * <p>
     * MainCalculator 클래스를 실행하여 계산기 UI를 표시
     * </p>
     *
     * @param args 명령줄 인수
     */

    public static void main(String[] args) {
        new MainCalculator();
    }
}

