package shixun.lj.bw.liuj2019218;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import shixun.lj.bw.liuj2019218.adapter.Myadapter;
import shixun.lj.bw.liuj2019218.bean.Data;
import shixun.lj.bw.liuj2019218.presenter.Showpresenter;
import shixun.lj.bw.liuj2019218.view.Showview;

public class MainActivity extends AppCompatActivity implements Showview {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recy);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        //分割线
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.onDraw(c, parent, state);
                Paint paint = new Paint();
                paint.setColor(Color.BLUE);
                c.drawRect(0, 0, 3000, 100, paint);
            }

            @Override
            public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.onDrawOver(c, parent, state);
                Paint paint = new Paint();
                paint.setColor(Color.BLUE);
                c.drawRect(0, 0, 3000, 200, paint);
            }

            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(10, 10, 10, 10);
            }
        });

        Showpresenter showpresenter = new Showpresenter(MainActivity.this);
        showpresenter.showluoji();
    }

    @Override
    public void showview(Data data) {
        final List<Data.DataBeanX.DataBean> data1 = data.getData().getData();

        final Myadapter myadapter = new Myadapter(data1, MainActivity.this);
        myadapter.setOnitemclick(new Myadapter.onitemclick() {
            @Override
            public void onlongclick(int i) {
                myadapter.remove(i);

                Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(myadapter);


    }
}
