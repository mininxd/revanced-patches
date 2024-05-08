package app.revanced.patches.reddit.ad.general.fingerprints

import app.revanced.patcher.extensions.or
import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint
import org.jf.dexlib2.AccessFlags
import org.jf.dexlib2.Opcode

internal object AdPostFingerprint : MethodFingerprint(
    returnType = "V",
    access = AccessFlags.PUBLIC or AccessFlags.CONSTRUCTOR,
    opcodes = listOf(
        Opcode.INVOKE_DIRECT,
        Opcode.IPUT_OBJECT
    ),
    // "children" are present throughout multiple versions
    strings = listOf(
        "children",
        "uxExperiences"
    ),
    customFingerprint = { methodDef, classDef ->
        methodDef.definingClass.endsWith("/Listing;")
                && methodDef.name == "<init>"
                && classDef.sourceFile == "Listing.kt"
    },
)
