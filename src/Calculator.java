import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {
    Calculator(){
            setTitle("계산기");
            this.setSize(368,489);
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            PanelNorth();
            PanelCenter();
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

        add(panel, BorderLayout.NORTH);
    }

    void PanelCenter(){

    }

    void PanelSouth(){

    }


    public static void main(String[] args) {
    new Calculator();
    }
}
