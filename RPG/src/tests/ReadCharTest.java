package tests;

import java.awt.event.*;

public class ReadCharTest {
    public static void main(String[] args) {

    }

    public class keybord extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            Character text = new Character(e.getKeyChar());

        }
    }
}
