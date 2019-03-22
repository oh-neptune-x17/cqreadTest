import java.awt.*;

public class Tile extends RenderedObject {

    Tile(int x, int y, Handler handler){
        super(x,y, handler);

    }
    @Override
    public void tick(){}

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x,y,1,1);

    }
    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,1,1);
    }
}
