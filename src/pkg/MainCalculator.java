package pkg;

import javax.swing.*;

public class MainCalculator extends JFrame {
    MainCalculator(){
        setTitle("계산기");
        //코드 추가

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 300);
        setVisible(true);
    }
    public static void main(String[] args) {
    new MainCalculator();
    }
}
