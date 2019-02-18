package shixun.lj.bw.liuj2019218.main;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import shixun.lj.bw.liuj2019218.bean.Data;
import shixun.lj.bw.liuj2019218.utils.OkhttpClientUtils;

/*
  name:刘江
  data:2019
*/public class ShowModel {
    //接口回到
    public interface Showclick {
        void show(Data data);
    }

    Showclick showclick;

    public void setShowclick(Showclick showclick) {
        this.showclick = showclick;
    }

    private int page = 1;
    private String url = "http://365jia.cn/news/api3/365jia/news/headline?page=" + page;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    String datas = (String) msg.obj;
                    Gson gson = new Gson();
                    Data data = gson.fromJson(datas, Data.class);
                    if (showclick != null) {
                        showclick.show(data);
                    }
                    break;
            }
        }
    };

    public void showData() {
        OkhttpClientUtils.doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Message message = new Message();
                message.obj = string;
                message.what = 1;
                handler.sendMessage(message);


            }
        });

    }
}
