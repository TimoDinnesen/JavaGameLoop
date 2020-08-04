import static java.lang.Thread.sleep;

/**
 *  The game loop ties everything together and provides timing of rendering and the model.
 *  The loop provides a fixed "Tickrate" eg the smallest physical step.
 *  It ensures that all these are done every second, no matter how often things are rendered.
 *
 *  Further improvements:
 *  Clamping
 *  If rendering or physics run a risk of taking a long time, "clamping" should be implemented.
 *  Eg. if there is not time for all ticks to be done, the engine must not try to keep up.
 *
 *  Interpolation
 *  A value can be calculated that will smooth physics. The value can be passed on to physics.
 *  The value could be calculated as "the rest of the accumulator / desiredTicksPerSecond"
 */

public class GameLoop implements Runnable {

    private volatile boolean running = true;  //A global flag that indicates if the thread is running or not.

    long desiredTicksPerSecond = 100;
    long physicsDeltaTime = 1000 / desiredTicksPerSecond;
    long accumulator;  // Accumulator keeps track of how many milliseconds physics need to process, to keep up with real time.
    long lastFrameStartTime = System.currentTimeMillis();

    private int dazValue = 0;
    private long currentFrameStartTime;

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }

    Renderer renderer;

    public void setModel(Model model) {
        this.model = model;
    }

    Model model;

    @Override
    public void run() {
        while(running){
            currentFrameStartTime = System.currentTimeMillis();
            accumulator = accumulator + currentFrameStartTime - lastFrameStartTime;
            // Clamping can be added here.
            // if accumulator is bigger than some value it should just be set to that value.


            lastFrameStartTime = currentFrameStartTime;
            while(accumulator >  physicsDeltaTime) {
                doPhysics();
                accumulator = accumulator - physicsDeltaTime;
            }

            doRender();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void doRender() {
        renderer.doRender();
        //System.out.println("Some Physics value: " + dazValue + " Accumulator leftover for next loop: " + accumulator);
    }

    private void doPhysics() {
        model.doPhysics();
    }

    public void stop() {
        this.running = false;
    }
}
