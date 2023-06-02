package com.mos.tar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.mos.com.R;
import com.mos.tar.DataBaseStuff.infoDataBaseAdapter;

import java.util.ArrayList;

public class debt_page extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;
    Button bt;
    ArrayList<debt_data> debt_data = new ArrayList<>();
    ListView listView;
    ListView_adapter adapter;
    private RecyclerView recyclerView;
    com.mos.tar.DataBaseStuff.infoDataBaseAdapter infoDataBaseAdapter;
    private infoDataBaseAdapter mDatabase;
    recyclerAdapter RVadapter;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dept_page);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9694193635894998/3323457674");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        editText = findViewById(R.id.editTextTextPersonName);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        infoDataBaseAdapter = new infoDataBaseAdapter(this);

        infoDataBaseAdapter = infoDataBaseAdapter.open();

        recyclerView = (RecyclerView) findViewById(R.id.list_items);


        if (infoDataBaseAdapter.isNotEmpty()) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setHasFixedSize(true);
            mDatabase = new infoDataBaseAdapter(this);
            debt_data = mDatabase.listContacts();
            RVadapter = new recyclerAdapter(this, debt_data);
            recyclerView.setAdapter(RVadapter);
        }

        display();

    }


    public void display() {
        recyclerView = (RecyclerView) findViewById(R.id.list_items);
        bt = (Button) findViewById(R.id.button);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));


        recyclerAdapter adapter = new recyclerAdapter(this, debt_data);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO : add here advertisement
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");

                    // get the tall number from the page
                    EditText name = (EditText) findViewById(R.id.name);
                    String finalName = name.getText().toString();

                    // get the wide number from the page
                    EditText amount = (EditText) findViewById(R.id.amount);
                    String strAmount = amount.getText().toString();
                    double finalAmount = Double.parseDouble(strAmount);

                    //get the notes from the user
                    EditText notes = (EditText) findViewById(R.id.notes);
                    String finalNotes = notes.getText().toString();


                    if (!(finalName.equals("") || strAmount.equals("") || finalNotes.equals(""))) {


                        // process the tar data and wide in the  array list
                        debt_data newData = new debt_data(finalName, finalAmount, finalNotes);

                        infoDataBaseAdapter.insertEntry(newData);

                        Toast.makeText(getApplicationContext(), "تمت العملية بنجاح", Toast.LENGTH_LONG).show();

                        debt_data.add(newData);

                        RecyclerView.LayoutManager lm = new LinearLayoutManager(com.mos.tar.debt_page.this);

                        recyclerView.setLayoutManager(lm);
                        recyclerView.setAdapter(adapter);

                        name.getText().clear();
                        amount.getText().clear();
                        notes.getText().clear();

                    }
                }
            }
        });
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

        infoDataBaseAdapter.close();
    }

}
