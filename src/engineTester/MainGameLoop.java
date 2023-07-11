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
		
		//OpenGL vertices counterclockwise (two triangles that shapes a rectangle)
		float[] vertices = {
				//left bottom triangle
				-0.5f,0.5f,0f, 	//v0
				-0.5f,-0.5f,0f,	//v1
				0.5f,-0.5f,0f, 	//v2
				0.5f,0.5f,0f,	//v4

		};
		
		int [] indices = {
				0,1,3,
				1,2,3
		};
		
		RawModel model = loader.loadToVAO(vertices,indices);
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
