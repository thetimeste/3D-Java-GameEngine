package renderEngine;

 
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class DisplayManager {
	
	//declare display size 
	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;
	private static final int FPS_CAP = 100;
	
	public static void createDisplay() {
		//attribute settings
		ContextAttribs attribs = new ContextAttribs(3,2);
		attribs.withForwardCompatible(true);
		attribs.withProfileCore(true);
		
		try {
			 
			Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
			Display.create(new PixelFormat(),attribs);
			Display.setTitle("Java Game Engine");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//where to display
		GL11.glViewport(0, 0, WIDTH, HEIGHT);
	}
	
	public static void updateDisplay() {
		//sync the game to run at specific FPS rate
		Display.sync(FPS_CAP);
		Display.update();
	}
	
	public static void closeDisplay() {
		//close display
		Display.destroy(); 
	}

}
