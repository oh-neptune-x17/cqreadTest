
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


public class Render extends Canvas implements Runnable {
    private BufferedImage loadqr;

    private Handler handler;
    private Thread thread;
    private boolean isRunning = false;
    /////////// KONSTRUKTOR
    private Render() {
        handler = new Handler();
        BufferedImgLoader loader = new BufferedImgLoader();
        loadqr = loader.loadMap("qrcode.png");
        new Window(loadqr.getWidth()+50, loadqr.getHeight()+68, this);
        loadLevelMap(loadqr);
        start();

    }

    private void start(){
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }
    private void stop(){
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //////////////////////////////////////


    ////////////////////////////// METODA RUN AUTORSTWA MARKUSA PERSSONA "NOTCHA"
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        int frames = 0;
        double ticksAmount = 60.0; //liczba odswiezen na sekunde
        double nsPerSec = 1000000000.0/ticksAmount;
        double unprocessed = 0;
        long timer = System.currentTimeMillis();

        while(isRunning){
            long now = System.nanoTime();
            unprocessed += (now - lastTime)/nsPerSec;
            lastTime = now;
            while(unprocessed>=1){
                tick();
                unprocessed--;
            }

            render();

            frames++;

            if(System.currentTimeMillis() - timer > 1000){
               timer += 1000;
                frames = 0;
            }
      }
        stop();
    }

    private void tick(){
        handler.tick();
    }

    ///////////////////////////// WSZYSTKO CO RYSUJEMY ZNAJDUJE SIE W TEJ FUNKCJI
    private void render()  {

        BufferStrategy strat = this.getBufferStrategy();

        if (strat == null){
            this.createBufferStrategy(3); // ladujemy do pamieci ramki ktore dopiero beda wyswietlone
            return;
        }
        Graphics g = strat.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;

        // rysujemy tutaj

        for (int xx = 16; xx < loadqr.getWidth()+16 ; xx ++) {
            for (int yy = 16; yy < loadqr.getHeight()+16 ; yy ++) {
                g.setColor(Color.WHITE);
                g.fillRect(xx,yy,1,1);
            }
        }

        handler.render(g);

        g.dispose();
        strat.show();

    }

    private void loadLevelMap(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();

        for (int x = 16; x < w+16; x++) {
            for (int y = 16; y < h+16; y++) {
                int pixel = image.getRGB(x-16, y-16);
                int blue = (pixel) & 0xff;
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;

                if (blue == 255) {
                    handler.addObject(new Tile(x, y, handler));
                }
           //     else if (green == 255) {
           //         handler.addObject(new Tile(x, y, handler));
           //     }
           //     else if (red == 255) {
           //         handler.addObject(new Tile(x, y, handler));
                }
            }
        }


    public static void main(String[] args) {
        Render render = new Render();
    }

}

