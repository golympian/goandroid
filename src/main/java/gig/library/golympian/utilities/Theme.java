package gig.library.golympian.utilities;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import gig.library.golympian.R;

import static gig.library.golympian.base.Constants.aresconstants;

/**
 * Created by thecarisma on 12/23/2017.
 */

public class Theme {

    private Activity activity ; private SharedPreferences settings ;

    /**
     * the currently supported themes
     */
    public enum Themes {
        HERATHEME, REDFIRE, NATURE, GREENLIFE, SKYBLUE, COOLBLUE, AQUAMARINE, BUTTER
    }

    /**
     * theme constructor with activity
     * @param activity the initializer activity
     */
    public Theme(Activity activity) {
        this.activity = activity ;
        settings = PreferenceManager.getDefaultSharedPreferences(activity);
    }

    /**
     * set the theme you desire after constructing with the activity initializer
     * else error will occur
     * @throws null activity error
     * @param theme the theme you wish to apply
     */
    public void setTheme(Themes theme) {
        activity.setTheme(getThemeId(theme));
    }

    /**
     * set the theme you desire after constructing with the activity initializer during runtime anytime
     * else error will occur
     * @throws null activity error
     * @param theme the theme you wish to apply
     */
    public void applyTheme(Themes theme) {
        activity.setTheme(getThemeId(theme)); activity.recreate();
    }

    /**
     * set the theme you desire passing the activity and the themes
     * @throws null activity error
     * @param theme the theme you wish to apply
     */
    public static void setTheme(Activity activity, Themes theme) {
        activity.setTheme(getThemeId(theme));
    }

    /**
     * set the theme you desire passing the activity and the themes during runtime anytime
     * @throws null activity error
     * @param theme the theme you wish to apply
     */
    public static void applyTheme(Activity activity, Themes theme) {
        activity.setTheme(getThemeId(theme)); activity.recreate();
    }

    /**
     * returns developers the theme saved in the activity preference
     * @return saved theme
     */
    public Themes getSavedTheme() {
        return getThemeId(settings.getInt(aresconstants.THEME, R.style.HeraTheme));
    }

    /**
     * get the themes value of the style id
     * @param id the style id you wish to get
     * @return the themes value of the theme
     */
    public static Themes getThemeId(int id) {
        if (id == R.style.HeraTheme) {
            return Themes.HERATHEME ;
        } else if (id == R.style.RedFire ) {
            return Themes.REDFIRE ;
        } else if (id == R.style.Nature ) {
            return Themes.NATURE ;
        } else if (id == R.style.GreenLife ) {
            return Themes.GREENLIFE ;
        } else if (id == R.style.SkyBlue ) {
            return Themes.SKYBLUE ;
        } else if (id == R.style.CoolBlue ) {
            return Themes.COOLBLUE ;
        } else if (id == R.style.AquaMarine ) {
            return Themes.AQUAMARINE ;
        } else if (id == R.style.Butter ) {
            return Themes.BUTTER ;
        }
        return Themes.HERATHEME ;
    }

    /**
     * get the style id of the theme you wish to apply
     * @param theme the theme you wish to apply
     * @return the style id of the theme
     */
    public static int getThemeId(Themes theme) {
        if (theme == Themes.HERATHEME) {
            return R.style.HeraTheme ;
        } else if (theme == Themes.REDFIRE) {
            return R.style.RedFire ;
        } else if (theme == Themes.NATURE) {
            return R.style.Nature ;
        } else if (theme == Themes.GREENLIFE) {
            return R.style.GreenLife ;
        } else if (theme == Themes.SKYBLUE) {
            return R.style.SkyBlue ;
        } else if (theme == Themes.COOLBLUE) {
            return R.style.CoolBlue ;
        } else if (theme == Themes.AQUAMARINE) {
            return R.style.AquaMarine ;
        } else if (theme == Themes.BUTTER) {
            return R.style.Butter ;
        }
        return R.style.HeraTheme ;
    }

}