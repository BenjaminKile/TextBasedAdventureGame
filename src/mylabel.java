import javax.swing.*;
import java.awt.*;

public class mylabel extends JLabel {
    mylabel(){
        this.setForeground(Color.BLACK);
        this.setFont(new Font("Comic Sans", Font.PLAIN,20));
        //this.setBounds(0,0,800, 400);
        this.setVerticalAlignment(JLabel.TOP);
        this.setHorizontalAlignment(JLabel.LEFT);
    }
}
