import java.awt.*;

public abstract class RenderedObject {
    private Handler handler;

    int x;
    int y;
    private float vel_x = 0, vel_y = 0;

    RenderedObject(int x, int y, Handler handler){
        this.x = x;
        this.y = y;

        this.handler = handler;

    }
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();  // do detekcji kolizji
    // getters and setters Code > Generate


    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public float getVel_x() {
        return vel_x;
    }
    public void setVel_x(float vel_x) {
        this.vel_x = vel_x;
    }
    public float getVel_y() {
        return vel_y;
    }
    public void setVel_y(float vel_y) {
        this.vel_y = vel_y;
    }
}
