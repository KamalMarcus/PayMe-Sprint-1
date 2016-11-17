package com.kamal.marcus.facebooklogin;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by KiMoo on 08/11/2016.
 */

public class TwoFragment extends Fragment {
    private ArrayList<Card> cardsList;

    public TwoFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_two, container, false);

        cardsList=new ArrayList<Card>();
        cardsList.add(new Card("Netflix Card","Buy your Netflix card and start streaming your favourite movies and TV series",R.drawable.netflix));
        cardsList.add(new Card("ebay Cards","Buy ebay card and enjoy shopping for : Fashion, Electronics, collectibles and many others on one of the leading e-commerce companies in the world",R.drawable.ebay));
        cardsList.add(new Card("Rinboo Recharge Cards","Premium Quality International Calls to landlines and mobiles at super cheap rates",R.drawable.rinpoo));
        cardsList.add(new Card("Telemedic SAL","TeleMedic SAL is a medical device company dedicated to eliminating the distance between the patient and his physician by providing up-to-date innovative medical technology.",R.drawable.telemedic));
        cardsList.add(new Card("Anghami","Anghami is your music hub from which you can instantly play any Arabic and International song or album wherever you are",R.drawable.anghami));

        ListView cardsListView= (ListView) rootView.findViewById(R.id.cards_list_view);
        CardsAdapter adapter=new CardsAdapter(getContext(),cardsList);
        cardsListView.setAdapter(adapter);

        return rootView;
    }
}