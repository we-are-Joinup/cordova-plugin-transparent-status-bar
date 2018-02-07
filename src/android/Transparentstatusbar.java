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
import android.os.Bundle;
import android.widget.Toast;

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
        private int getStatusBarHeight() {
            int height;

            Resources myResources = getResources();
            int idStatusBarHeight = myResources.getIdentifier(
                    "status_bar_height", "dimen", "android");
            if (idStatusBarHeight > 0) {
                height = getResources().getDimensionPixelSize(idStatusBarHeight);
                Toast.makeText(this,
                        "Status Bar Height = " + height,
                        Toast.LENGTH_LONG).show();
            } else{
                height = 0;
                Toast.makeText(this,
                        "Resources NOT found",
                        Toast.LENGTH_LONG).show();
            }

            return height;
        }
}
