package thecarisma.golympian.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

import thecarisma.golympian.utilities.Font;
import thecarisma.golympian.utilities.Language;
import thecarisma.golympian.utilities.Theme;

/**
 * Created by thecarisma on 12/23/2017.
 */

public class BaseActivity extends AppCompatActivity {

    public SharedPreferences settings ; public Theme.Themes theme = Theme.Themes.HERATHEME;
    public Font font ; public static BaseActivity baseActivity ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settings = PreferenceManager.getDefaultSharedPreferences(this); initActivity() ;
        baseActivity = this ; AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public void initActivity() {
        theme = Theme.getThemeId(settings.getInt("THEME", Theme.getThemeId(Theme.Themes.HERATHEME)));
        Theme.setTheme(this, Theme.getThemeId(settings.getInt("THEME", Theme.getThemeId(Theme.Themes.HERATHEME))));
        font = new Font(this);
        Language.setLanguage(this, settings.getString("LANGUAGE",Language.getLanguage(Language.Languages.ENGLISH)));
        font.overrideFont(this, "SERIF", font.getSavedFont());
    }

    public void setTitle(String title) {
        if ( getSupportActionBar() != null) getSupportActionBar().setTitle(title);
    }

    @Override
    protected void attachBaseContext(Context base){
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public BaseActivity getBaseActivity() {
        return this ;
    }

    //we are not using a custom shared preference becuse we want other activity that extends this class
    //to have access to the shared preference
    //settings = this.getSharedPreferences(aresconstants.SHAREDPREFERENCENAME, MODE_PRIVATE);
}