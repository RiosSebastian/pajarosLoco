import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
       int boardWidth = 360;
       int boardHeight= 640;

       JFrame frame = new JFrame("pajaro");
       frame.setSize(boardWidth,boardHeight);
       frame.setLocationRelativeTo(null);
       frame.setResizable(false);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       Pajaro pajaro = new Pajaro();
       frame.add(pajaro);
       frame.pack();

       frame.setVisible(true);

    }
}
