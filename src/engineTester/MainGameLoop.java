package engineTester;

 
import org.lwjgl.opengl.Display;

import models.RawModel;
import models.TexturedModel;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;


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
		
		//how to connect the vertex
		int [] indices = {
				0,1,3,
				1,2,3
		};
		
		//coordinates of texture (whole texture's square)
		float[] textureCoords = {
				0,0, //v0
				0,1, //v1
				1,1, //v2
				1,0 //v3
		};
		
		
		RawModel model = loader.loadToVAO(vertices,textureCoords,indices);
		ModelTexture texture = new ModelTexture(loader.loadTexture(("image")));
		TexturedModel texturedModel = new TexturedModel(model, texture);
		
		//main game loop (loops until window is not closed)
		while(!Display.isCloseRequested()) {
			renderer.prepare();
			shader.start();
			renderer.render(texturedModel);
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
