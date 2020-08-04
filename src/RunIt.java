/**
 * This class simply instantiates all objects,
 * tells them about each other,
 * and starts the game loop.
 */

public class RunIt {
    public static void main(String[] args) {
        Model model = new Model();

        Renderer renderer = new Renderer();
        renderer.setModel(model);

        GameLoop gameLoop = new GameLoop();
        gameLoop.setModel(model);
        gameLoop.setRenderer(renderer);

        //Create a thread and start it.
        Thread gameLoopThread = new Thread(gameLoop);
        gameLoopThread.start();
    }
}
