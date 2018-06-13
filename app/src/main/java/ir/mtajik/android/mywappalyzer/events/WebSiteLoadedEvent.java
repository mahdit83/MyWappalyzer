package ir.mtajik.android.mywappalyzer.events;

import ir.mtajik.android.mywappalyzer.dto.WebsiteDto;

public class WebSiteLoadedEvent {

    private WebsiteDto websiteDto;

    public WebSiteLoadedEvent(WebsiteDto websiteDtoe) {
        this.websiteDto = websiteDto;
    }

    public WebsiteDto getWebsiteDto() {
        return websiteDto;
    }

}
