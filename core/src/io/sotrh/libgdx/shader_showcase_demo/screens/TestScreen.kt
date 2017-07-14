package io.sotrh.libgdx.shader_showcase_demo.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.glutils.ShaderProgram
import io.sotrh.libgdx.shader_showcase_demo.BaseScreen
import io.sotrh.libgdx.shader_showcase_demo.ShaderShowcaseDemo

/**
 * Created by benjamin on 7/12/17
 */
class TestScreen(parent: ShaderShowcaseDemo) : BaseScreen(parent) {

    private lateinit var texture: Texture
    private lateinit var shader: ShaderProgram

    override fun show() {
        parent.apply {
            texture = textureManager.getTexture("badlogic.jpg")
            shader = ShaderProgram(
                    Gdx.files.internal("shaders/basic.vs.glsl"),
                    Gdx.files.internal("shaders/black_and_white.fs.glsl")
            )

        }
    }

    override fun render(delta: Float) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        parent.apply {
            spriteBatch.projectionMatrix = orthoCamera.combined
            spriteBatch.begin()
            spriteBatch.shader = shader
            spriteBatch.draw(texture, Gdx.graphics.width / 2f - texture.width / 2f, Gdx.graphics.height / 2f - texture.height / 2f)
            spriteBatch.shader = null
            defaultFont.draw(spriteBatch, "FPS: ${Gdx.graphics.framesPerSecond}", 10f, 20f)
            spriteBatch.end()
        }
    }

    override fun dispose() {
        shader.dispose()
    }
}