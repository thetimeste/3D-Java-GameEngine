package engineTester;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;

public class MainGameLoop {

	public static void main(String[] args) {
		//create display
		DisplayManager.createDisplay();
		
		//main game loop (loops until window is not closed)
		while(!Display.isCloseRequested()) {
			 
			//render
			DisplayManager.updateDisplay();
		}
		
		//close display
		DisplayManager.closeDisplay();
	}

}
