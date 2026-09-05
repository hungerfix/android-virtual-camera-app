package com.meharimamily.virtualcamera.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CameraConfig(
    val id: String,
    val name: String,
    val videoPath: String = "",
    val imagePath: String = "",
    val resolution: Resolution = Resolution(1920, 1080),
    val frameRate: Int = 30,
    val enableSound: Boolean = true,
    val flipHorizontal: Boolean = false,
    val rotateAngle: Int = 0,
    val targetApps: List<String> = emptyList(),
    val isActive: Boolean = false
)

@Serializable
data class Resolution(
    val width: Int,
    val height: Int
) {
    override fun toString(): String = "${width}x${height}"
}

@Serializable
data class FrameData(
    val frameId: Long,
    val timestamp: Long,
    val width: Int,
    val height: Int,
    val data: ByteArray,
    val format: String = "NV21"
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as FrameData
        if (frameId != other.frameId) return false
        if (timestamp != other.timestamp) return false
        if (width != other.width) return false
        if (height != other.height) return false
        if (!data.contentEquals(other.data)) return false
        if (format != other.format) return false
        return true
    }

    override fun hashCode(): Int {
        var result = frameId.hashCode()
        result = 31 * result + timestamp.hashCode()
        result = 31 * result + width
        result = 31 * result + height
        result = 31 * result + data.contentHashCode()
        result = 31 * result + format.hashCode()
        return result
    }
}
