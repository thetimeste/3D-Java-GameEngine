package renderEngine;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public class Renderer {

	public void prepare() {
		//erase previous frame
		GL11.glClearColor(1, 0, 0, 1);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
	}
	
	//render the actual model stored in the VAO
	public void render(RawModel model) {
		GL30.glBindVertexArray(model.getVaoID()); //bind the VAO
		GL20.glEnableVertexAttribArray(0);
		GL11.glDrawElements(GL11.GL_TRIANGLES,model.getVertexCount(),GL11.GL_UNSIGNED_INT,0);
		GL20.glDisableVertexAttribArray(0); 
		GL30.glBindVertexArray(0); //unbind VAO
	}
}
