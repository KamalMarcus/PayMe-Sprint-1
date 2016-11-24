package com.kamal.marcus.facebooklogin.Payment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;

import com.kamal.marcus.facebooklogin.R;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        PaymentFragment paymentFragment = new PaymentFragment();
        fragmentTransaction.add(R.id.payment_fragment_container, paymentFragment);
        fragmentTransaction.commit();

    }


}
