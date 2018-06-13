package ir.mtajik.android.mywappalyzer.dto;

import java.util.List;

public class PagedCompanies {

    private List<CompanyDto> Data;
    private int PageIndex;
    private int Total;
//    private Err

    public List<CompanyDto> getData() {
        return Data;
    }

    public void setData(List<CompanyDto> data) {
        this.Data = data;
    }

    public int getPageIndex() {
        return PageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.PageIndex = pageIndex;
    }


    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        this.Total = total;
    }
}
