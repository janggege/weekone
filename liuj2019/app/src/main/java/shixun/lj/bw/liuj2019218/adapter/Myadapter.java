package shixun.lj.bw.liuj2019218.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import shixun.lj.bw.liuj2019218.R;
import shixun.lj.bw.liuj2019218.bean.Data;

/*
  name:刘江
  data:2019
*/public class Myadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Data.DataBeanX.DataBean> list;
    Context context;
    private final int ONE = 0;
    private final int TWO = 1;

    @Override
    public int getItemViewType(int position) {
        if (position % 3 == 0) {
            return ONE;
        } else {
            return TWO;
        }
    }

    public Myadapter(List<Data.DataBeanX.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == ONE) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.holder1, null, false);
            Myviewholder myviewholder = new Myviewholder(view);
            return myviewholder;
        } else if (i == TWO) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.holder2, null, false);
            Myviewholder1 myviewholder1 = new Myviewholder1(view);
            return myviewholder1;

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        String path = "http://365jia.cn/uploads/appletrecommend/201804/5ad6ba6c6bb8b.jpg";
        String path1 = "http://365jia.cn/uploads/special/tuku/201804/5ad6ab1059e6566912.jpg";
        if (viewHolder instanceof Myviewholder) {
            Myviewholder myviewholder = (Myviewholder) viewHolder;
            DisplayImageOptions build = new DisplayImageOptions.Builder()
                    .cacheOnDisk(true)
                    .build();
            myviewholder.textView.setText(list.get(i).getTitle());
            ImageLoader.getInstance().displayImage(path, myviewholder.imageView, build);
            myviewholder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onitemclick.onlongclick(i);
                    remove(i);

                    return true;
                }
            });


        } else if (viewHolder instanceof Myviewholder1) {
            Myviewholder1 myviewholder = (Myviewholder1) viewHolder;
            myviewholder.textView1.setText(list.get(i).getTitle());
            DisplayImageOptions build = new DisplayImageOptions.Builder()
                    .cacheOnDisk(true)
                    .build();
            ImageLoader.getInstance().displayImage(path1, myviewholder.imageView, build);
            myviewholder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onitemclick.onlongclick(i);
                    remove(i);
                    return true;
                }
            });


        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Myviewholder extends RecyclerView.ViewHolder {

        private final TextView textView;
        private final ImageView imageView;

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
            imageView = itemView.findViewById(R.id.image);
        }
    }

    class Myviewholder1 extends RecyclerView.ViewHolder {

        private final TextView textView1;
        private final ImageView imageView;

        public Myviewholder1(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.text1);
            imageView = itemView.findViewById(R.id.image1);
        }
    }

    //长按借口
    public interface onitemclick {
        void onlongclick(int i);

    }

    onitemclick onitemclick;

    public void setOnitemclick(Myadapter.onitemclick onitemclick) {
        this.onitemclick = onitemclick;
    }

    //删除
    public void remove(int i) {
        list.remove(i);
        notifyItemRemoved(i);
        notifyDataSetChanged();

    }
}
