package shixun.lj.bw.liuj2019218.presenter;

import shixun.lj.bw.liuj2019218.MainActivity;
import shixun.lj.bw.liuj2019218.bean.Data;
import shixun.lj.bw.liuj2019218.main.ShowModel;
import shixun.lj.bw.liuj2019218.view.Showview;

/*
  name:刘江
  data:2019
*/public class Showpresenter {

    private final ShowModel showModel;
    private final Showview showview1;

    public Showpresenter(Showview showview) {
        showModel = new ShowModel();
        showview1 = showview;


    }

    public void showluoji() {
        showModel.showData();
        showModel.setShowclick(new ShowModel.Showclick() {
            @Override
            public void show(Data data) {
                showview1.showview(data);
            }
        });
    }
}
