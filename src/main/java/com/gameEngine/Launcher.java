package com.gameEngine;

import java.util.Random;

import core.WindowManager;

public class Launcher { 
    private static final float RED_255 = 71;
    private static final float GREEN_255 = 255;
    private static final float BLUE_255 = 154;
    private static final float RED = RED_255 / 255;
    private static final float GREEN = GREEN_255 / 255;
    private static final float BLUE = BLUE_255 / 255;

    //Loader loader = new Loader();
    //Renderer renderer = new Renderer(RED, GREEN, BLUE);

    public static void main(String[] args) {
        WindowManager windowManager = new WindowManager("Our first window2!", 1280, 720, false);
        windowManager.init();
        windowManager.setClearColor(RED, GREEN, BLUE, 1);
        
        Random random = new Random();
        while(!windowManager.windowShouldClose()) {
            windowManager.update();
        }

        windowManager.cleanUp();
    }
}