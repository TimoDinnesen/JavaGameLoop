/**
 * The model represents the world, and is in charge of calculating physics on the worlds objects.
 *
 * This example simply calculates 2 points spinning around.
 *
 * Further improvements:
 * Interpolation - A value could be received from the gameloop, letting physics calculations
 * be smoothed out a bit, when ever the ticks allow for extra calculations per frame.
 *
 * Ticks per second could be passed along, so the model can take it into account.
  */

public class Model {
    double r = 0;
    public int x1;
    public int y1;
    public int x2;
    public int y2;

    public Model(){
        doPhysics(); // Make sure the points have been calculated in case they are drawn before doPhysics is called from the gameloop.
    }

    public void doPhysics(){
        r =  r + ((Math.PI / 100.0));
        x1 = (int)(Math.sin(r)*200.0+250.0);
        y1 = (int)(Math.cos(r)*200.0+250.0);
        x2 = (int)(Math.sin(r+Math.PI)*200.0+250.0);
        y2 = (int)(Math.cos(r+Math.PI)*200.0+250.0);
    }
}
