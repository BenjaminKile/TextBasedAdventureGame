import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Myframe extends JFrame implements ActionListener {
    JButton button1;

    Myframe(){
        JButton button1 = new JButton();
        button1.setBounds(100, 200,100, 50 );
        button1.addActionListener(this);

        JButton button2 = new JButton();
        button2.setBounds(250, 200, 100, 50);
        JButton button3 = new JButton();
        button3.setBounds(400, 200, 100, 50);

        this.setTitle("Maze Adventure");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(800, 600);
        this.setLayout(null);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1);
        System.out.println("Left");

    }
}