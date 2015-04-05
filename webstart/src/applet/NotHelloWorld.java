package applet;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lenovo on 2015/4/5.
 */
public class NotHelloWorld extends JApplet
{
    public void init()
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run() {
                JLabel label= new JLabel("Not a Hello, World applet", SwingConstants.CENTER);
                add(label);
            }
        });
    }
}
