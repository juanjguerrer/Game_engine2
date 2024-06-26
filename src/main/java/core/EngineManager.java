package core;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;

import com.gameEngine.Launcher;

import core.utils.Consts;

public class EngineManager {
    public static final long NANOSECOND = 1000000000;
    public static final float FRAME_RATE = 1000.0f;

    private static int fps;
    private static float frametime = 1.0f / FRAME_RATE;

    private boolean isRunning;

    private WindowManager window;
    private GLFWErrorCallback errorCallback;

    private void init() throws Exception{
        GLFW.glfwSetErrorCallback(errorCallback = GLFWErrorCallback.createPrint(System.err));
        window = Launcher.getWindow();
        window.init(); 
    }

    public void start() throws Exception{
        init();
        if(isRunning) {
            return;
        }
        run();
    }

    public void run(){
        this.isRunning = true;
        int frames = 0;
        long frameCounter = 0;
        long lastTime = System.nanoTime();
        double unprocessedTime = 0;

        while(isRunning){
            boolean render = false;
            long startTime = System.nanoTime();
            long passedTime = startTime - lastTime;
            lastTime = startTime;

            unprocessedTime += passedTime / (double) NANOSECOND;
            frameCounter += passedTime;

            input();

            // input
            while (unprocessedTime>frametime) {
                render = true;
                unprocessedTime -= frametime;

                if (window.windowShouldClose()) {
                    stop();
                }

                if(frameCounter >= NANOSECOND) {
                    setFps(frames);
                    window.setTitle(Consts.TITLE + "FPS: " + frames);
                    frames = 0;
                    frameCounter = 0;
                }
            }
            if(render) {
                update();
                render();
                frames++;
            }
        }
        cleanUp();
    }

    private void stop(){
        if (!isRunning) {
            return;
        }
        isRunning = false;
    }

    private void input(){}

    private void render(){
        window.update();
    }

    public static int getFps() {
        return fps;
    }

    public static void setFps(int fps) {
        EngineManager.fps = fps;
    }

    private void update(){};

    private void cleanUp(){
        window.cleanUp();
        errorCallback.free();
        GLFW.glfwTerminate();
    }

}
