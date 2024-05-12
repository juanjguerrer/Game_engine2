package com.gameEngine;

import java.util.Random;

import core.EngineManager;
import core.WindowManager;
import core.utils.Consts;

public class Launcher { 
    private static final float RED_255 = 71;
    private static final float GREEN_255 = 255;
    private static final float BLUE_255 = 154;
    private static final float RED = RED_255 / 255;
    private static final float GREEN = GREEN_255 / 255;
    private static final float BLUE = BLUE_255 / 255;

    private static WindowManager window;
    private static EngineManager engine;
    //Loader loader = new Loader();
    //Renderer renderer = new Renderer(RED, GREEN, BLUE);

    public static void main(String[] args) {
        window = new WindowManager(Consts.TITLE, 1280, 720, false);
        engine = new EngineManager();
        //window.setClearColor(RED, GREEN, BLUE, 1);

        try {
            engine.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WindowManager getWindow() {
        return window;
    }
}