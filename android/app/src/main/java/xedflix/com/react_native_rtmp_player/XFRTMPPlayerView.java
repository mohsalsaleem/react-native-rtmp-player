package xedflix.com.react_native_rtmp_player;

import android.content.Context;
import android.net.Uri;
import android.view.SurfaceView;
import android.widget.FrameLayout;

import com.pedro.vlc.VlcListener;
import com.pedro.vlc.VlcVideoLibrary;

/**
 * Created by mohsal on 3/2/18.
 */

public class XFRTMPPlayerView extends FrameLayout implements VlcListener {
    private static final String TAG = "XFRTMPPlayerView";

    VlcVideoLibrary vlcVideoLibrary;

    protected String source;
    Context context;
    boolean hasSource = false;

    public XFRTMPPlayerView(Context context) {
        super(context);
    }

    public void setSource(Uri source) {
        this.source = source.toString();
        hasSource = true;
        initializePlayer();
    }

    public void initializePlayer() {
        SurfaceView surfaceView = findViewById(R.id.player_view);
        vlcVideoLibrary = new VlcVideoLibrary(getContext(), this, surfaceView);
    }

    public void start() {
        if(vlcVideoLibrary != null) {
            vlcVideoLibrary.play(source);
        }
    }

    public void stop() {
        if(vlcVideoLibrary != null) {
            vlcVideoLibrary.stop();
        }
    }

    public void pause() {
        if(vlcVideoLibrary != null) {
            vlcVideoLibrary.pause();
        }
    }

    public static boolean isValidSource(Uri source) {
        return source.getScheme().equals("rtmp://") || source.getScheme().equals("rtmps://");
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError() {

    }
}
