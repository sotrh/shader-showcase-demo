package io.sotrh.libgdx.shader_showcase_demo

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.PerspectiveCamera
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g3d.ModelBatch
import io.sotrh.libgdx.shader_showcase_demo.managers.TextureManager
import io.sotrh.libgdx.shader_showcase_demo.screens.TestScreen

class ShaderShowcaseDemo : Game() {

    lateinit var defaultFont: BitmapFont private set
    lateinit var spriteBatch: SpriteBatch private set
    lateinit var modelBatch: ModelBatch private set
    lateinit var orthoCamera: OrthographicCamera private set
    lateinit var perspectiveCamera: PerspectiveCamera private set

    val textureManager = TextureManager()

    override fun create() {
        defaultFont = BitmapFont()
        spriteBatch = SpriteBatch()
        modelBatch = ModelBatch()
        orthoCamera = OrthographicCamera()
        perspectiveCamera = PerspectiveCamera()
        setScreen(TestScreen(this))
    }

    override fun resize(width: Int, height: Int) {
        super.resize(width, height)
        orthoCamera.setToOrtho(false, width.toFloat(), height.toFloat())
        orthoCamera.position.set(width / 2f, height / 2f, 0f)
        orthoCamera.update()

        perspectiveCamera.viewportWidth = width.toFloat()
        perspectiveCamera.viewportHeight = height.toFloat()
        perspectiveCamera.update()
    }

    override fun render() {
        super.render()
    }

    override fun dispose() {
        super.dispose()
        defaultFont.dispose()
        spriteBatch.dispose()
        modelBatch.dispose()
        textureManager.disposeAll()
    }
}
