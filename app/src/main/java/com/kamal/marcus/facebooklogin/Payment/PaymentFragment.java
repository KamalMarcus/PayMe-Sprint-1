package com.kamal.marcus.facebooklogin.Payment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.kamal.marcus.facebooklogin.Card;
import com.kamal.marcus.facebooklogin.R;
import com.squareup.picasso.Picasso;

/**
 * Created by KiMoo on 08/11/2016.
 */

public class PaymentFragment extends android.app.Fragment {
    private WebView webView;

    public PaymentFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Card selectedCard = getActivity().getIntent().getParcelableExtra("selectedCard");

        View rootView = inflater.inflate(R.layout.fragment_payment, container, false);

        ImageView cardIcon= (ImageView) rootView.findViewById(R.id.card_icon);
        Picasso.with(getActivity().getApplicationContext()).load(selectedCard.getImageUrl()).into(cardIcon);

        TextView cardName= (TextView) rootView.findViewById(R.id.card_name);
        cardName.setText(selectedCard.getName());

        TextView cardDetails= (TextView) rootView.findViewById(R.id.card_details);
        cardDetails.setText(selectedCard.getDetails());

        webView=(WebView)rootView.findViewById(R.id.web_view);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.paymeapp.co/");
        webView.setFocusable(false);

        return rootView;
    }
}
