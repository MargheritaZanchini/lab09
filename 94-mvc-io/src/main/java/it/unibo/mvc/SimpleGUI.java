package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();

    private SimpleGUI(Controller controller){
        //frame
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 3, sh / 3);
        //panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        //textField
        JTextField text = new JTextField();
        panel.add(text, BorderLayout.NORTH);
        //textArea
        JTextArea area = new JTextArea();
        panel.add(area, BorderLayout.CENTER);
        //second panel and the two buttons in it
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        JButton print = new JButton("print");
        JButton showHistory = new JButton("show history");
        southPanel.add(print, BorderLayout.CENTER);
        southPanel.add(showHistory,BorderLayout.AFTER_LAST_LINE);
        panel.add(southPanel, BorderLayout.SOUTH);

        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setString(text.getText());
                controller.printString();
            }
        });

        showHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                area.setText(controller.getHistory().toString());
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
    }

    private void display(){
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SimpleGUI gui = new SimpleGUI(new SimpleController());
        gui.display();
    }

}
