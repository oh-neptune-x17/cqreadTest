import java.awt.*;
import java.util.LinkedList;

public class Handler {
    Render render;

    private LinkedList<RenderedObject> object = new LinkedList<>();

    public void tick(){
        for (RenderedObject tempObject : object) {
            tempObject.tick();
        }
    }
    public void render(Graphics g) {
        for (RenderedObject tempObject : object) {
            tempObject.render(g);
        }

    }

    void addObject(RenderedObject tempObject){
        object.add(tempObject);
    }

    public void removeObject (RenderedObject tempObject){
        object.remove(tempObject);
    }


}
