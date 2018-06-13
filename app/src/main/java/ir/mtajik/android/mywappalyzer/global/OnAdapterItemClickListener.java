package ir.mtajik.android.mywappalyzer.global;

public interface OnAdapterItemClickListener<T> {

    void onAdapterItemClick(T t);

    void onAdapterItemSelect(T t);

    void onAdapterItemLongClick(T t);
}
