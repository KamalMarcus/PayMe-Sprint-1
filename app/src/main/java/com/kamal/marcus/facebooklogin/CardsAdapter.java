package com.kamal.marcus.facebooklogin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by KiMoo on 25/10/2016.
 */

public class CardsAdapter extends ArrayAdapter<Card> {

    public CardsAdapter(Context context, List<Card> cards) {
        super(context, 0, cards);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Card card=getItem(position);

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        convertView = inflater.inflate(R.layout.products_list_item_card, parent, false);

        ImageView cardIcon= (ImageView) convertView.findViewById(R.id.card_icon);
        cardIcon.setImageResource(card.getIcon());

        TextView cardName= (TextView) convertView.findViewById(R.id.card_name);
        cardName.setText(card.getName());

        TextView cardDetails= (TextView) convertView.findViewById(R.id.card_details);
        cardDetails.setText(card.getDetails());

        return convertView;
    }
}
