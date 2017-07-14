package io.sotrh.libgdx.shader_showcase_demo.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import io.sotrh.libgdx.shader_showcase_demo.ShaderShowcaseDemo;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new ShaderShowcaseDemo(), config);
	}
}
