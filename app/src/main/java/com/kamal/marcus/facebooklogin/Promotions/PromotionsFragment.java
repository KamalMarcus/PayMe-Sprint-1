package com.kamal.marcus.facebooklogin.Promotions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.kamal.marcus.facebooklogin.Payment.PaymentActivity;
import com.kamal.marcus.facebooklogin.R;

import static com.kamal.marcus.facebooklogin.MainActivity.PromotionsCardsList;

/**
 * Created by KiMoo on 08/11/2016.
 */

public class PromotionsFragment extends Fragment {


    public PromotionsFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_promotions, container, false);

//        PromotionsCardsList=new ArrayList<Card>();
//        PromotionsCardsList.add(new Card("Netflix Card","Buy your Netflix card and start streaming your favourite movies and TV series",R.drawable.netflix));
//        PromotionsCardsList.add(new Card("ebay Cards","Buy ebay card and enjoy shopping for : Fashion, Electronics, collectibles and many others on one of the leading e-commerce companies in the world",R.drawable.ebay));
//        PromotionsCardsList.add(new Card("Rinboo Recharge Cards","Premium Quality International Calls to landlines and mobiles at super cheap rates",R.drawable.rinpoo));
//        PromotionsCardsList.add(new Card("Telemedic SAL","TeleMedic SAL is a medical device company dedicated to eliminating the distance between the patient and his physician by providing up-to-date innovative medical technology.",R.drawable.telemedic));
//        PromotionsCardsList.add(new Card("Anghami","Anghami is your music hub from which you can instantly play any Arabic and International song or album wherever you are",R.drawable.anghami));

        final ListView cardsListView= (ListView) rootView.findViewById(R.id.cards_list_view);
        CardsAdapter adapter=new CardsAdapter(getContext(), PromotionsCardsList);
        cardsListView.setAdapter(adapter);
        cardsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getActivity(),PaymentActivity.class);
                intent.putExtra("selectedCard", PromotionsCardsList.get(i));
                startActivity(intent);

            }
        });

        return rootView;
    }
}
