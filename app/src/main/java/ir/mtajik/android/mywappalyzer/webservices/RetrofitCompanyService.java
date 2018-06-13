package ir.mtajik.android.mywappalyzer.webservices;

import ir.mtajik.android.mywappalyzer.dto.PagedCompanies;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitCompanyService {

    @GET("company/search/")
    Call<PagedCompanies> searchCompany(@Query("langid") int langId ,@Query("pageindex") int pageIndex);
}
