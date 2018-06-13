package ir.mtajik.android.mywappalyzer.dto;

import java.io.Serializable;

public class WebsiteDto implements Serializable {

    private String url;
    private String email;
    private boolean isWordPress;
    private boolean isJoomla;
    private String source;

    public WebsiteDto(String url, String email) {
        this.url = url;
        this.email = email;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isWordPress() {
        return isWordPress;
    }

    public void setWordPress(boolean wordPress) {
        isWordPress = wordPress;
    }

    public boolean isJoomla() {
        return isJoomla;
    }

    public void setJoomla(boolean joomla) {
        isJoomla = joomla;
    }

    public String getUrl() {
        return url;
    }

    public String getEmail() {
        return email;
    }
}
