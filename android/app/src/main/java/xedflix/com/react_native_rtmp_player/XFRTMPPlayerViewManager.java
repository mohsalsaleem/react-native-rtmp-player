package xedflix.com.react_native_rtmp_player;

import android.net.Uri;

import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.ReactProp;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

import javax.annotation.Nullable;

/**
 * Created by mohsal on 3/2/18.
 */

public class XFRTMPPlayerViewManager extends SimpleViewManager<XFRTMPPlayerView> implements LifecycleEventListener {

    public static final String REACT_CLASS = "XFRTMPPlayer";

    private XFRTMPPlayerView xfrtmpPlayerView;
    private ReactContext reactContext;

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected XFRTMPPlayerView createViewInstance(ThemedReactContext reactContext) {
        this.reactContext = reactContext;
        xfrtmpPlayerView = new XFRTMPPlayerView(reactContext);
        return xfrtmpPlayerView;
    }

    @ReactProp(name = "src")
    public void setSrc(XFRTMPPlayerView view, String source) {
        view.setSource(Uri.parse(source));
    }

    @Override
    public void onHostResume() {
        xfrtmpPlayerView.start();
    }

    @Override
    public void onHostPause() {
        xfrtmpPlayerView.pause();
    }

    @Override
    public void onHostDestroy() {
        xfrtmpPlayerView.stop();
    }
}
