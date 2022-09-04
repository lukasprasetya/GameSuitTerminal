package utils

object IOUtils {
    fun readString(default: String = ""): String {
        return readLine() ?: ""
    }
}