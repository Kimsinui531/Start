import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {
    private JTextField inputSpace; // 입력 필드
    private JTextArea area; // 히스토리 표시 영역


    Calculator(){
            setTitle("계산기");
            setSize(368,489);
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            PanelNorth();
            PanelSouth();// 메서드 호출

            setVisible(true);
    }

    void PanelNorth(){
        JPanel panel = new JPanel();
        JTextArea area = new JTextArea(10,40);
        area.setText("");
        area.setEditable(false);
        area.setForeground(Color.BLACK);
        panel.add(area);
    }

    void PanelSouth(){ //

    }


    public static void main(String[] args) {
    new Calculator();
    }
}
