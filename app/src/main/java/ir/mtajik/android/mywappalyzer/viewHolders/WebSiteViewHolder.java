package ir.mtajik.android.mywappalyzer.viewHolders;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import ir.mtajik.android.mywappalyzer.R;
import ir.mtajik.android.mywappalyzer.dto.WebsiteDto;
import ir.mtajik.android.mywappalyzer.global.OnAdapterItemClickListener;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class WebSiteViewHolder extends BaseViewHolder<WebsiteDto> {

    static public int type = R.layout.web_item;
    private Context context;

    private TextView webAddress, emailAddress;
    private ImageView technologyIcon, noEmailIcon;
    private CheckBox checkBox;

    public WebSiteViewHolder(Context context, View itemView, OnAdapterItemClickListener
            onItemClickListener) {
        super(itemView);

        this.onItemClickListener = onItemClickListener;
        this.context = context;
        initViews(itemView);

    }

    @Override
    public void onBindView(WebsiteDto data) {

        if (!TextUtils.isEmpty(data.getUrl())) {
            webAddress.setText(data.getUrl());
        }
        if (!TextUtils.isEmpty(data.getEmail())) {
            emailAddress.setText(data.getEmail());
            noEmailIcon.setVisibility(View.GONE);
            emailAddress.setVisibility(VISIBLE);
        } else {
            noEmailIcon.setVisibility(VISIBLE);
            emailAddress.setVisibility(GONE);
        }
        if (!TextUtils.isEmpty(data.getUrl())) {
            webAddress.setText(data.getUrl());
        }
        if (isSiteIsWordPress(data)) {
            technologyIcon.setImageResource(R.drawable.ic_wordpress);
            technologyIcon.setVisibility(VISIBLE);
        } else if (isSiteIsJoomla(data)) {
            technologyIcon.setImageResource(R.drawable.ic_joomla);
            technologyIcon.setVisibility(VISIBLE);

        } else {
            technologyIcon.setVisibility(GONE);

        }
    }

    @Override
    int getItemType() {
        return type;
    }

    private void initViews(View itemView) {

        webAddress = itemView.findViewById(R.id.textView_url);
        emailAddress = itemView.findViewById(R.id.textView_email);
        technologyIcon = itemView.findViewById(R.id.imageView_tech_icon);
        checkBox = itemView.findViewById(R.id.checkbox);
        noEmailIcon = itemView.findViewById(R.id.imageView_no_email);
    }

    private boolean isSiteIsJoomla(WebsiteDto data) {
        return false;
    }

    private boolean isSiteIsWordPress(WebsiteDto data) {
        if (data.getSource() != null) {
            if (data.getSource().contains("wp-content")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
