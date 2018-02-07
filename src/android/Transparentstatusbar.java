package it.tangodev.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
//status bar height reference
import android.content.res.Resources;

public class Transparentstatusbar extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if (action.equals("isTransparent")) {
            boolean result = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
            int statusBarHeight = getStatusBarHeight();
            callbackContext.success(result ? statusBarHeight : 0);
            return true;
        } else {
            return false;
        }
    }
    
    // A method to find height of the status bar
        public int getStatusBarHeight() {
                int result = 0;
                int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
                if (resourceId > 0) {
                        result = getResources().getDimensionPixelSize(resourceId);
                }
                return result;
        }
}
