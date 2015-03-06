/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.swing.JFrame;

/**
 *
 * @author pol
 */
public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Chat");
        frame.setBounds(100, 50, 445, 492);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainPanel panel = new MainPanel();
        frame.add(panel);
        frame.setVisible(true);
    }
}
