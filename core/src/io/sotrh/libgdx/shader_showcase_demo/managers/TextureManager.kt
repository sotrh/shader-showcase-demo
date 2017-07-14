package io.sotrh.libgdx.shader_showcase_demo.managers

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture

/**
 * Created by benjamin on 7/13/17
 */
class TextureManager {

    private val textureMap = mutableMapOf<String, Texture>()

    fun getTexture(textureName: String): Texture {
        return textureMap[textureName]
                ?: Texture(Gdx.files.internal("textures/$textureName")).apply {
            textureMap.put(textureName, this)
        }
    }

    fun disposeTexture(textureName: String) {
        textureMap[textureName]?.dispose()
        textureMap.remove(textureName)
    }

    fun disposeAll() {
        textureMap.values.forEach { it.dispose() }
        textureMap.clear()
    }
}