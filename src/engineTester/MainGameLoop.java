package engineTester;

 
import org.lwjgl.opengl.Display;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;


public class MainGameLoop {

	public static void main(String[] args) {
		//create display
		DisplayManager.createDisplay();
		
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		
		//OpenGL vertices defined counter clockwise by default
		float[] vertices = {
				//left bottom triangle
				-0.5f,0.5f,0f,
				-0.5f,-0.5f,0f,
				0.5f,-0.5f,0f,
				//right top triangle
				0.5f,-0.5f,0f,
				0.5f,0.5f,0f,
				-0.5f,0.5f,0f
		};
		
		RawModel model = loader.loadToVAO(vertices);
		//main game loop (loops until window is not closed)
		while(!Display.isCloseRequested()) {
			renderer.prepare();
			//render
			renderer.render(model);
			DisplayManager.updateDisplay();
		}
		
		//close display
		DisplayManager.closeDisplay();
		//cleanup loader
		loader.cleanUp();
	}

}
