package ir.mtajik.android.mywappalyzer.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import ir.mtajik.android.mywappalyzer.global.OnAdapterItemClickListener;
import ir.mtajik.android.mywappalyzer.viewHolders.BaseViewHolder;
import ir.mtajik.android.mywappalyzer.viewHolders.WebSiteViewHolder;

public class WebDtoAdapter<T> extends RecyclerView.Adapter<BaseViewHolder<T>> {

    Context context;
    private ArrayList<T> data;
    private OnAdapterItemClickListener onItemClickListener;
    private BaseViewHolder viewHolder;

    public WebDtoAdapter(Context context, ArrayList<T> data, OnAdapterItemClickListener<T>
            onItemClickListener) {
        this.context = context;
        this.data = data;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public BaseViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        viewHolder = null;

        if (viewType == WebSiteViewHolder.type) {
            viewHolder = new WebSiteViewHolder(context, LayoutInflater.from(context).inflate
                    (WebSiteViewHolder.type, parent, false), onItemClickListener);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<T> holder, int position) {

        viewHolder.onBindView(data.get(position));

    }

    @Override
    public int getItemViewType(int position) {
        //we can use switch case but simple way is return the resource id that we got!
        return WebSiteViewHolder.type;
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void addAll(ArrayList<T> newItems) {
        int lastItem = data.size();
        data.addAll(newItems);
        notifyItemChanged(lastItem);
    }
}
