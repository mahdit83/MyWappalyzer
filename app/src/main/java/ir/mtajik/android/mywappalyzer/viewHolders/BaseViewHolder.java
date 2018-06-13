package ir.mtajik.android.mywappalyzer.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import ir.mtajik.android.mywappalyzer.global.OnAdapterItemClickListener;


public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {


    protected OnAdapterItemClickListener onItemClickListener;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBindView(T data);

    abstract int getItemType();

    public void setOnItemClickListener(OnAdapterItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener<T> {
        void onItemClick(View view, T data);

        void onItemLongClick(View view, T data);
    }


}