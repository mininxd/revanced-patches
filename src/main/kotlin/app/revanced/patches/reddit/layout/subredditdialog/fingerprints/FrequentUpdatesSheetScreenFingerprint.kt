package app.revanced.patches.reddit.layout.subredditdialog.fingerprints

import app.revanced.patcher.extensions.or
import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint
import org.jf.dexlib2.AccessFlags
import org.jf.dexlib2.Opcode

internal object FrequentUpdatesSheetScreenFingerprint : MethodFingerprint(
    returnType = "Landroid/view/View;",
    access = AccessFlags.PUBLIC or AccessFlags.FINAL,
    opcodes = listOf(
        Opcode.CONST,
        Opcode.INVOKE_STATIC,
        Opcode.MOVE_RESULT_OBJECT,
        Opcode.CHECK_CAST,
        Opcode.IF_EQZ
    ),
    strings = listOf("inflater"),
    customFingerprint = { _, classDef ->
        classDef.sourceFile == "FrequentUpdatesSheetScreen.kt"
    }
)