package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();

    private SimpleGUIWithFileChooser(final Controller controller){
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 4, sh / 4);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea text = new JTextArea();
        panel.add(text);

        JButton save = new JButton("Save");
        panel.add(save, BorderLayout.SOUTH);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());

        JTextField field = new JTextField();
        field.setText(controller.getPath());
        field.setEditable(false);
        northPanel.add(field, BorderLayout.CENTER);
        JButton browse = new JButton("Browse...");
        northPanel.add(browse, BorderLayout.LINE_END);

        panel.add(northPanel, BorderLayout.NORTH);

        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.writeOnFile(text.getText());
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(browse);
                if(result == JFileChooser.APPROVE_OPTION){
                    controller.setFile(fileChooser.getSelectedFile().getAbsolutePath());
                    field.setText(controller.getPath());
                }else if(result == JFileChooser.CANCEL_OPTION){
                    //it does nothing
                }else{
                    JOptionPane.showMessageDialog(frame, result);
                }
                panel.add(fileChooser);
            }
            
        });

        frame.setContentPane(panel);

        frame.setVisible(true);
    }
    public static void main(String[] args){
        new SimpleGUIWithFileChooser(new Controller());
    }

}
