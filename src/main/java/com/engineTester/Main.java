package com.engineTester;

import renderEngine.DisplayManager;

public class Main { 
    private static final float RED_255 = 71;
    private static final float GREEN_255 = 154;
    private static final float BLUE_255 = 255;
    private static final float RED = RED_255 / 255;
    private static final float GREEN = GREEN_255 / 255;
    private static final float BLUE = BLUE_255 / 255;
    public static void main(String[] args) {
        DisplayManager.createDisplay(RED, GREEN, BLUE);
    }
}