package com.ellen.ylbase.log;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ellen.ylbase.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * 界面日志打印器
 * 可以在App界面上显示日志
 */
public class YlViewPrinter implements YlLogPrinter {
    private RecyclerView recyclerView;
    private YlViewAdapter adapter;
    private YlViewPrinterProvider ylViewPrinterProvider;

    public YlViewPrinter(Activity activity) {
        FrameLayout rootView = activity.findViewById(android.R.id.content);
        recyclerView = new RecyclerView(activity);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new YlViewAdapter(LayoutInflater.from(recyclerView.getContext()));
        recyclerView.setAdapter(adapter);
        ylViewPrinterProvider = new YlViewPrinterProvider(rootView,recyclerView);
    }

    /**
     * 获取ViewProvider，通过ViewProvider可以控制log视图的展示和隐藏
     *
     * @return ViewProvider
     */
    @NonNull
    public YlViewPrinterProvider getViewProvider() {
        return ylViewPrinterProvider;
    }


    @Override
    public void print(@NonNull YlLogConfig config, int level, String tag, @NonNull String printString) {
        // 将log展示添加到recycleView
        adapter.addItem(new YlLogBean(System.currentTimeMillis(), level, tag, printString));

        // 滚动到对应的位置
        recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
    }

    private class YlViewAdapter extends RecyclerView.Adapter<YlViewHolder> {

        private List<YlLogBean> ylLogBeanList;
        private LayoutInflater inflater;

        public YlViewAdapter(LayoutInflater inflater) {
            this.inflater = inflater;
        }

        @NonNull
        @Override
        public YlViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = inflater.inflate(R.layout.view_yl_log, parent, false);
            return new YlViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull YlViewHolder holder, int position) {
            YlLogBean itemBean = ylLogBeanList.get(position);
            int color = getHighLightColor(itemBean.level);

            holder.tvTag.setTextColor(color);
            holder.tvContent.setTextColor(color);

            holder.tvTag.setText(itemBean.getFlattened());
            holder.tvContent.setText(itemBean.log);
        }

        /**
         * 不同的日志级别显示不同的颜色
         * @param logLevel
         * @return
         */
        private int getHighLightColor(int logLevel) {
            int highlight;
            switch (logLevel) {
                case YlLogType.V:
                    highlight = 0xffbbbbbb;
                    break;
                case YlLogType.D:
                    highlight = 0xffffffff;
                    break;
                case YlLogType.I:
                    highlight = 0xff6a8759;
                    break;
                case YlLogType.W:
                    highlight = 0xffbbb529;
                    break;
                case YlLogType.E:
                    highlight = 0xffff6b68;
                    break;
                default:
                    highlight = 0xffffff00;
                    break;
            }
            return highlight;
        }

        public void addItem(YlLogBean bean) {
            if(ylLogBeanList == null){
                ylLogBeanList = new ArrayList<>();
            }
            ylLogBeanList.add(bean);
            notifyDataSetChanged();
        }

        @Override
        public int getItemCount() {
            return ylLogBeanList == null ? 0 : ylLogBeanList.size();
        }
    }

    private class YlViewHolder extends RecyclerView.ViewHolder {
        TextView tvTag, tvContent;

        public YlViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTag = itemView.findViewById(R.id.tv_tag);
            tvContent = itemView.findViewById(R.id.tv_content);
        }
    }
}
