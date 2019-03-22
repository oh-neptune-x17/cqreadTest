import javax.swing.*;
import java.awt.*;

class Window {

    private String title = "QR kod";

    Window(int width, int height, Render render){

        JFrame jframe = new JFrame(this.title);
        Dimension dimension = new Dimension(width,height);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setMaximumSize(dimension);
        jframe.setMinimumSize(dimension);
        jframe.setPreferredSize(dimension);
        jframe.setResizable(false);
        jframe.add(render);

        jframe.setVisible(true);

    }



}
