
package chat;

import java.awt.GraphicsConfiguration;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Chat");
        frame.setBounds(100, 50, 477, 490);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainPanel panel = new MainPanel();
        frame.add(panel);
        frame.setVisible(true);
    }
}
