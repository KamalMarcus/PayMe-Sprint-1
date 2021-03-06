package com.kamal.marcus.facebooklogin.Merchants;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kamal.marcus.facebooklogin.Card;
import com.kamal.marcus.facebooklogin.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by KiMoo on 15/11/2016.
 */

public class GridAdapter extends ArrayAdapter<Card> {

    public GridAdapter(Context context, List<Card> cards) {
        super(context, 0, cards);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Card card=getItem(position);

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        convertView = inflater.inflate(R.layout.merchants_grid_item, parent, false);

        ImageView cardIcon= (ImageView) convertView.findViewById(R.id.card_icon);
        Picasso.with(getContext()).load(card.getImageUrl()).into(cardIcon);

        TextView cardName= (TextView) convertView.findViewById(R.id.card_name);
        cardName.setText(card.getName());

        TextView cardDetails= (TextView) convertView.findViewById(R.id.card_details);
        cardDetails.setText(card.getDetails());

        return convertView;
    }
}

