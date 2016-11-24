package com.kamal.marcus.facebooklogin;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import com.kamal.marcus.facebooklogin.Merchants.MerchantsFragment;
import com.kamal.marcus.facebooklogin.Promotions.PromotionsFragment;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    public static ArrayList<Card> PromotionsCardsList;
    public static ArrayList<Card> MerchantsCardsList;
    public static ArrayList<Card> ProductsCardsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PromotionsCardsList =new ArrayList<Card>();
        MerchantsCardsList=new ArrayList<Card>();
        ProductsCardsList=new ArrayList<Card>();

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String jsonTest="{\"merchants\":[{\"name\":\"PayME\",\"description\":null,\"logo\":\"https://s3.amazonaws.com/paymeimg/logos/PayME.png\",\"qr_code\":\"00010101\"},{\"name\":\"Jumia\",\"description\":null,\"logo\":\"https://s3.amazonaws.com/paymeimg/logos/Jumia.png\",\"qr_code\":\"00020101\"},{\"name\":\"McDonalds\",\"description\":null,\"logo\":\"https://s3.amazonaws.com/paymeimg/logos/McDonalds.jpg\",\"qr_code\":\"00030101\"},{\"name\":\"FC Barcelona\",\"description\":null,\"logo\":\"https://app.paymeapp.co/logos/download.png\",\"qr_code\":\"00040101\"},{\"name\":\"PayME App\",\"description\":null,\"logo\":null,\"qr_code\":\"00050101\"},{\"name\":\"Abdallah\",\"description\":null,\"logo\":\"https://app.paymeapp.co/logos/Abdallah.jpg?v=1.2\",\"qr_code\":\"00060101\"},{\"name\":\"zalbya\",\"description\":null,\"logo\":null,\"qr_code\":\"00070101\"},{\"name\":\"SOUQ\",\"description\":null,\"logo\":\"https://s3.amazonaws.com/paymeimg/logos/SOUQ.png\",\"qr_code\":\"00080101\"},{\"name\":\"Aramex\",\"description\":null,\"logo\":\"https://app.paymeapp.co/logos/Aramex.png\",\"qr_code\":\"00090101\"},{\"name\":\"seoudi\",\"description\":null,\"logo\":\"https://s3.amazonaws.com/paymeimg/logos/seoudi.jpg\",\"qr_code\":\"00100101\"},{\"name\":\"Madrid\",\"description\":null,\"logo\":\"https://app.paymeapp.co/logos/Madrid.png\",\"qr_code\":\"00110101\"},{\"name\":\"mrcc\",\"description\":null,\"logo\":null,\"qr_code\":\"00120101\"},{\"name\":\"merchprof\",\"description\":null,\"logo\":\"https://app.paymeapp.co/logos/merchprof.png\",\"qr_code\":\"00130101\"},{\"name\":\"Life Makers\",\"description\":null,\"logo\":\"https://s3.amazonaws.com/paymeimg/logos/Life Makers.png\",\"qr_code\":\"00140101\"},{\"name\":\"Egy Delivery\",\"description\":null,\"logo\":\"https://s3.amazonaws.com/paymeimg/logos/Egy Delivery.png\",\"qr_code\":\"00150101\"},{\"name\":\"Kites Egypt\",\"description\":null,\"logo\":\"https://s3.amazonaws.com/paymeimg/logos/Kites Egypt.png\",\"qr_code\":\"00160101\"},{\"name\":\"merchantTrial\",\"description\":null,\"logo\":\"https://s3.amazonaws.com/paymeimg/logos/merchantTrial.png\",\"qr_code\":\"00170101\"},{\"name\":\"merchantTrial2\",\"description\":null,\"logo\":\"https://s3.amazonaws.com/paymeimg/logos/merchantTrial2.png\",\"qr_code\":\"00180101\"},{\"name\":\"merchantTest2\",\"description\":null,\"logo\":\"https://s3.amazonaws.com/paymeimg/logos/merchantTest2.png\",\"qr_code\":\"00190101\"},{\"name\":\"abdallah654654\",\"description\":null,\"logo\":\"https://s3.amazonaws.com/payme-dev/logos/abdallah654654.png\",\"qr_code\":\"00200101\"}],\"products\":[{\"id\":3,\"title\":\"Product title\",\"image\":null,\"description\":\"Product Desc\",\"category\":\"Education\"}],\"promotions\":[{\"id\":4,\"title\":\"Promotion title\",\"image\":\"Promotion.jpg\",\"description\":\"Promotion Desc\",\"category\":\"Tourism\"}]}\n";
        try {
            JSONObject json=new JSONObject(jsonTest);
            JSONArray promotionsArray=json.getJSONArray("promotions");
            for (int i=0;i<promotionsArray.length();i++){
                JSONObject obj=promotionsArray.getJSONObject(i);
                Card card=new Card();
                card.setName(obj.getString("title"));
                card.setDetails(obj.getString("description"));
                PromotionsCardsList.add(card);
            }
            JSONArray merchantsArray=json.getJSONArray("merchants");
            for(int i=0;i<merchantsArray.length();i++){
                JSONObject obj=merchantsArray.getJSONObject(i);
                Card card=new Card();
                card.setName(obj.getString("name"));
                card.setImageUrl(obj.getString("logo"));
                card.setDetails(obj.getString("description"));
                MerchantsCardsList.add(card);
            }
            JSONArray productsArray=json.getJSONArray("products");
            for(int i=0;i<productsArray.length();i++){
                JSONObject obj=productsArray.getJSONObject(i);
                Card card=new Card();
                card.setName(obj.getString("title"));
                card.setImageUrl("image");
                card.setDetails(obj.getString("description"));
                ProductsCardsList.add(card);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        viewPager= (ViewPager) findViewById(R.id.viewpager);
        setUpViewPager(viewPager);

        tabLayout= (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MerchantsFragment(),"Merchants");
        adapter.addFragment(new ProductsFragment(),"Products");
        adapter.addFragment(new PromotionsFragment(),"Promotions");
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_menu, menu);
        return true;
    }
}
