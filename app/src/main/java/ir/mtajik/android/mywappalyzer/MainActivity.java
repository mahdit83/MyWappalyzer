package ir.mtajik.android.mywappalyzer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import ir.mtajik.android.mywappalyzer.adapter.NullDeividerItemDecoration;
import ir.mtajik.android.mywappalyzer.adapter.WebDtoAdapter;
import ir.mtajik.android.mywappalyzer.dto.CompanyDto;
import ir.mtajik.android.mywappalyzer.dto.PagedCompanies;
import ir.mtajik.android.mywappalyzer.dto.WebsiteDto;
import ir.mtajik.android.mywappalyzer.events.WebSiteLoadedEvent;
import ir.mtajik.android.mywappalyzer.global.OnAdapterItemClickListener;
import ir.mtajik.android.mywappalyzer.service.MyIntentService;
import ir.mtajik.android.mywappalyzer.webservices.WebService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static ir.mtajik.android.mywappalyzer.service.MyIntentService.DTO_KEY;

public class MainActivity extends AppCompatActivity {

    private ArrayList<WebsiteDto> selected = new ArrayList<>();

    private RecyclerView recyclerView;
    private WebDtoAdapter webDtoAdapter;
    private WebService webService;
    private String token =
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJFbWFpbCI6ImFwaUBpbWljby5vcmciLCJFeHBpcmF0aW9uVGltZSI6IjIwMTgtMDYtMjBUMTI6MDU6MDAuMDYwMzU4NVoifQ.BhOoOmL1thNZ0fYtaWpcKz8ukoVYHiYU0rHLt579osw";
    private int pageNumber = 1;
    private int totalPage = 1000;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EventBus.getDefault().register(this);

        webService = new WebService(token);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        initializeUi();
        retriveDataFromWeb(pageNumber);
    }

    public void startService(WebsiteDto websiteDto) {

        Intent i = new Intent(MainActivity.this, MyIntentService.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(DTO_KEY, websiteDto);
        i.putExtras(bundle);
        startService(i);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(WebSiteLoadedEvent event) {

        ArrayList<WebsiteDto> list = new ArrayList<>();
        list.add(event.getWebsiteDto());
        renderView(list);
    }

    private void retriveDataFromWeb(int pageIndex) {

        webService.getAllCompanies(pageIndex, new Callback<PagedCompanies>() {
            @Override
            public void onResponse(Call<PagedCompanies> call, Response<PagedCompanies> response) {

                pageNumber++;
                totalPage = response.body().getTotal();
                initializeServices(convertResponseToWebSiteDto(response.body()));
                if (((totalPage / 10) - pageNumber) > 0) {
                    retriveDataFromWeb(pageNumber);
                }
            }

            @Override
            public void onFailure(Call<PagedCompanies> call, Throwable t) {

            }
        });
    }

    private List<WebsiteDto> convertResponseToWebSiteDto(PagedCompanies pagedCompanies) {

        List<WebsiteDto> list = new ArrayList<>();
        for (CompanyDto companyDto : pagedCompanies.getData()) {
            if (!TextUtils.isEmpty(companyDto.getWebsite())) {
                WebsiteDto websiteDto = new WebsiteDto(handleWebSite(companyDto.getWebsite()), companyDto
                        .getEmail());
                list.add(websiteDto);
            }
        }
        return list;
    }

    private String handleWebSite(String website) {
        if(website.contains("http//")){
            return website;
        }else{
            return  "http://"+website;
        }
    }


    private void initializeServices(List<WebsiteDto> data) {

        for (WebsiteDto websiteDto : data) {
            startService(websiteDto);
        }
    }

    private void initializeUi() {
        recyclerView = findViewById(R.id.recyclerView);

    }

    private void renderView(List<WebsiteDto> list) {

        if (webDtoAdapter == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.addItemDecoration(new NullDeividerItemDecoration());
            webDtoAdapter = new WebDtoAdapter<>(this, new ArrayList<>(list), new
                    OnAdapterItemClickListener<WebsiteDto>() {

                        @Override
                        public void onAdapterItemClick(WebsiteDto websiteDto) {

                        }

                        @Override
                        public void onAdapterItemSelect(WebsiteDto websiteDto) {

                        }

                        @Override
                        public void onAdapterItemLongClick(WebsiteDto websiteDto) {

                        }
                    });


            recyclerView.setAdapter(webDtoAdapter);
        } else {
            webDtoAdapter.addAll(new ArrayList<WebsiteDto>(list));
        }

    }

}
