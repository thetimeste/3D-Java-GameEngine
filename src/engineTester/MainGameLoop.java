package engineTester;

 
import org.lwjgl.opengl.Display;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;
import shaders.StaticShader;


public class MainGameLoop {

	public static void main(String[] args) {
		//create display
		DisplayManager.createDisplay();
		
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		StaticShader shader = new StaticShader();
		
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
			shader.start();
			renderer.render(model);
			shader.stop();
			DisplayManager.updateDisplay();
		}
		
		//shader cleanup
		shader.cleanUp();
		//cleanup loader
		loader.cleanUp();
		//close display
		DisplayManager.closeDisplay();
	}

}
