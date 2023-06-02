package com.example.matrialdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


public class MainActivity2 extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView ls;

    CoordinatorLayout coordinatorLayout;
    Snackbar snackbar;
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        toolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);
        fab=findViewById(R.id.fab);
        ls = findViewById(R.id.myRec);

      coordinatorLayout = findViewById(R.id.coordinator);
        DatabaseAccses db =DatabaseAccses.getInstance(getApplicationContext());
        /*
        هون الخلل
       db.open();
       ArrayList<User> arr = db.GetAllUsers();
       db.close();
*/
      //  RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
       // Adaptor adapter = new Adaptor(arr);
      //  ls.setLayoutManager(layoutManager);
       // ls.setAdapter(adapter);


         snackbar = Snackbar
                .make(coordinatorLayout, "You Press Add Button", Snackbar.LENGTH_LONG).setAction("Ok", new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         Toast.makeText(MainActivity2.this, "You pressed Ok", Toast.LENGTH_SHORT).show();
                     }
                 });
fab.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        snackbar=Snackbar.make(coordinatorLayout,"This is My Floating Action Button",Snackbar.LENGTH_LONG);
        snackbar.setAction("FAB", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        snackbar.show();
    }
});

    }//end on create


//  <---------------------------------------------------------------------------------------->


        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Add_item_menu :
                snackbar.show();
        }
        return false;
    }



}