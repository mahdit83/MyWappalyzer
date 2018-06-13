package ir.mtajik.android.mywappalyzer.webservices;

import java.io.IOException;

import ir.mtajik.android.mywappalyzer.dto.PagedCompanies;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebService {

    private OkHttpClient okHttpClient;

    public WebService(final String token) {

        okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request.Builder builder = originalRequest.newBuilder().header("Authorization",
                        token);

                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        }).build();
    }

    public void getAllCompanies(int pageIndex, Callback<PagedCompanies> callBack) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://service.imico.org/api/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitCompanyService retrofitCompanyService = retrofit.create(RetrofitCompanyService
                .class);

        Call<PagedCompanies> call = retrofitCompanyService.searchCompany(1,pageIndex);
        call.enqueue(callBack);
    }


}
