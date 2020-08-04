import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * The Renderer is in charge of drawing a model.
 * In this example it is simply calling some draw commands, but in a more finished product,
 * it should probably call classes that knows themselves how they should be drawn.
 */
public class Renderer {
    BufferStrategy strategy;
    JFrame frame;
    Model model;
    int fpsCounter = 0;
    int currentFps = 0;
    long timeSinceLastSecond;
    private long frameStartTime;

    public void setModel(Model model) {
        this.model = model;
    }

    public Renderer() {

        frame = new JFrame("JavaGameLoopExample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.createBufferStrategy(2);

        //Gets Graphics2D from the bufferstrategy

        strategy = frame.getBufferStrategy();
    }

    public void doRender(){
        fpsCounter = fpsCounter + 1;
        frameStartTime = System.currentTimeMillis();
        if(frameStartTime >= timeSinceLastSecond+1000) {
            currentFps = fpsCounter;
            fpsCounter = 0;
            timeSinceLastSecond = frameStartTime;
        }

        Graphics2D g = (Graphics2D) strategy.getDrawGraphics();


        //Draws a background and a line for testing
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 500, 500);
        g.setColor(Color.GREEN);
        g.drawLine(model.x1, model.y1, model.x2, model.y2);

        g.drawString("FPS: " + currentFps, 25, 50);
        // System.out.println("hh");
        //Displays the graphics to the frame
        //frame.update(g);
        g.dispose();
        strategy.show();
    }
}