package app.morphe.extension.shared.settings.preference;

import android.content.Context;
import android.preference.Preference;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import app.morphe.extension.shared.Utils;

/**
 * A placeholder preference showing the patches version.
 */
@SuppressWarnings({"unused", "deprecation"})
public class MorpheAboutPreference extends Preference {

    private void init() {
        setSelectable(false);
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);

        TextView titleView = view.findViewById(android.R.id.title);
        if (titleView != null) {
            String versionText = String.format("Patches version <i>%s</i>", Utils.getPatchesReleaseVersion());
            titleView.setText(Html.fromHtml(versionText));
        }
    }

    public MorpheAboutPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public MorpheAboutPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public MorpheAboutPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MorpheAboutPreference(Context context) {
        super(context);
        init();
    }
}
