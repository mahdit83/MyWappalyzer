package ir.mtajik.android.mywappalyzer.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.greenrobot.eventbus.EventBus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import ir.mtajik.android.mywappalyzer.dto.WebsiteDto;
import ir.mtajik.android.mywappalyzer.events.WebSiteLoadedEvent;

public class MyIntentService extends IntentService {

    public static String DTO_KEY = "DTO";
    private WebsiteDto websiteDto;


    public MyIntentService() {
        super("my intent service");

    }

    @Override
    protected void onHandleIntent(Intent intent) {


        websiteDto = (WebsiteDto) intent.getSerializableExtra(DTO_KEY);

        handleAddresses(websiteDto);

    }

    private void handleAddresses(WebsiteDto websiteDto) {

        String resString = "not successful";
        try {
            HttpClient httpclient = new DefaultHttpClient(); // Create HTTP Client
            HttpGet httpget = new HttpGet(websiteDto.getUrl()); // Set the action you want to do
            HttpResponse response = null; // Executeit

            response = httpclient.execute(httpget);

            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent(); // Create an InputStream with the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) // Read line by line
                sb.append(line + "\n");
            resString = sb.toString(); // Result is here
            is.close(); // Close the stream

            websiteDto.setSource(resString);
            EventBus.getDefault().post(new WebSiteLoadedEvent(websiteDto));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i("TAG", "process complete: " + resString);

    }

}
