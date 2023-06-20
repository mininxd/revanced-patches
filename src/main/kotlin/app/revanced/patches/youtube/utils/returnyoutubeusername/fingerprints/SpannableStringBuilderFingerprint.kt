package app.revanced.patches.youtube.utils.returnyoutubeusername.fingerprints

import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint
import org.jf.dexlib2.Opcode

object SpannableStringBuilderFingerprint : MethodFingerprint(
    returnType = "L",
    opcodes = listOf(
        Opcode.INVOKE_STATIC,
        Opcode.MOVE_RESULT_OBJECT,
        Opcode.CONST_4
    ),
    strings = listOf("TextComponentSpec: No converter for extension: %s")
)