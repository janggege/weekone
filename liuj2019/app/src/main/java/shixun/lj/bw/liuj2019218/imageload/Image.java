package shixun.lj.bw.liuj2019218.imageload;

import android.app.Application;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;

/*
  name:刘江
  data:2019   //imageloader
*/public class Image extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        String path = Environment.getExternalStorageDirectory() + "/price";
        ImageLoaderConfiguration builder = new ImageLoaderConfiguration.Builder(this)
                .diskCache(new UnlimitedDiskCache(new File(path)))
                .build();
        ImageLoader.getInstance().init(builder);

    }
}
