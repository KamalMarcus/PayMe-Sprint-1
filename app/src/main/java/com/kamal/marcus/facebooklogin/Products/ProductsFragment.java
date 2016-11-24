package com.kamal.marcus.facebooklogin.Products;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.kamal.marcus.facebooklogin.Payment.PaymentActivity;
import com.kamal.marcus.facebooklogin.Promotions.CardsAdapter;
import com.kamal.marcus.facebooklogin.R;

import static com.kamal.marcus.facebooklogin.MainActivity.ProductsCardsList;

/**
 * Created by KiMoo on 24/11/2016.
 */

public class ProductsFragment extends Fragment {


    public ProductsFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_promotions, container, false);

        final ListView cardsListView= (ListView) rootView.findViewById(R.id.cards_list_view);
        CardsAdapter adapter=new CardsAdapter(getContext(), ProductsCardsList);
        cardsListView.setAdapter(adapter);
        cardsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getActivity(),PaymentActivity.class);
                intent.putExtra("selectedCard", ProductsCardsList.get(i));
                startActivity(intent);

            }
        });

        return rootView;
    }
}