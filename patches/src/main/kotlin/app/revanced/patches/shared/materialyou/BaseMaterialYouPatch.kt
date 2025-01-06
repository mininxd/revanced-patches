package app.revanced.patches.shared.materialyou

import app.revanced.patcher.patch.PatchException
import app.revanced.patcher.patch.ResourcePatchContext
import app.revanced.util.copyXmlNode
import app.revanced.util.inputStreamFromBundledResource
import org.w3c.dom.Element
import org.w3c.dom.Node
import java.io.File
import java.nio.file.Files
import java.nio.file.StandardCopyOption
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.OutputKeys
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

private fun ResourcePatchContext.patchXmlFile(
    fromDir: String,
    toDir: String,
    xmlFileName: String,
    parentNode: String,
    targetNode: String? = null,
    attribute: String,
    newValue: String
) {
    val resourceDirectory = get("res")
    val fromDirectory = resourceDirectory.resolve(fromDir)
    val toDirectory = resourceDirectory.resolve(toDir)

    if (!toDirectory.isDirectory) Files.createDirectories(toDirectory.toPath())

    val fromXmlFile = fromDirectory.resolve(xmlFileName)
    val toXmlFile = toDirectory.resolve(xmlFileName)

    if (!fromXmlFile.exists()) {
        return
    }

    if (!toXmlFile.exists()) {
        Files.copy(
            fromXmlFile.toPath(),
            toXmlFile.toPath()
        )
    }

    document("res/$toDir/$xmlFileName").use { document ->
        val parentList = document.getElementsByTagName(parentNode).item(0) as Element

        if (targetNode != null) {
            for (i in 0 until parentList.childNodes.length) {
                val node = parentList.childNodes.item(i) as? Element ?: continue

                if (node.nodeName == targetNode && node.hasAttribute(attribute)) {
                    node.getAttributeNode(attribute).textContent = newValue
                }
            }
        } else {
            if (parentList.hasAttribute(attribute)) {
                parentList.getAttributeNode(attribute).textContent = newValue
            }
        }
    }
}

fun ResourcePatchContext.baseMaterialYou() {
    patchXmlFile(
        "drawable",
        "drawable-night-v31",
        "new_content_dot_background.xml",
        "shape",
        "solid",
        "android:color",
        "@android:color/system_accent1_100"
    )
    patchXmlFile(
        "drawable",
        "drawable-night-v31",
        "new_content_dot_background_cairo.xml",
        "shape",
        "solid",
        "android:color",
        "@android:color/system_accent1_100"
    )
    patchXmlFile(
        "drawable",
        "drawable-v31",
        "new_content_dot_background.xml",
        "shape",
        "solid",
        "android:color",
        "@android:color/system_accent1_200"
    )
    patchXmlFile(
        "drawable",
        "drawable-v31",
        "new_content_dot_background_cairo.xml",
        "shape",
        "solid",
        "android:color",
        "@android:color/system_accent1_200"
    )
    patchXmlFile(
        "drawable",
        "drawable-v31",
        "new_content_count_background.xml",
        "shape",
        "solid",
        "android:color",
        "@android:color/system_accent1_100"
    )
    patchXmlFile(
        "drawable",
        "drawable-v31",
        "new_content_count_background_cairo.xml",
        "shape",
        "solid",
        "android:color",
        "@android:color/system_accent1_100"
    )
    patchXmlFile(
        "layout",
        "layout-v31",
        "new_content_count.xml",
        "TextView",
        null,
        "android:textColor",
        "@android:color/system_neutral1_900"
    )
}