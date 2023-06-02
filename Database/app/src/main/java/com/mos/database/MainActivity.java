package com.mos.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn_save,btn_restore,btn_delete;
    EditText et_model,et_dpl,et_color,et_delete;
       MyDataBase db=new MyDataBase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_color=findViewById(R.id.et_color);
        et_dpl=findViewById(R.id.et_dpl);
        et_model=findViewById(R.id.et_model);
        et_delete=findViewById(R.id.et_delete);
        btn_restore=findViewById(R.id.btn_restore);
        btn_save=findViewById(R.id.btn_save);
        btn_delete=findViewById(R.id.btn_delete);
        btn_delete.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                et_color.setVisibility(View.GONE);
                et_dpl.setVisibility(View.GONE);
                et_model.setVisibility(View.GONE);
                et_delete.setVisibility(View.VISIBLE);
                return true;
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int s= Integer.parseInt(et_delete.getText().toString());
                Car car=new Car(s);
                db.Deletecar(car);
                et_color.setVisibility(View.VISIBLE);
                et_dpl.setVisibility(View.VISIBLE);
                et_model.setVisibility(View.VISIBLE);
                et_delete.setVisibility(View.GONE);
            }
        });
       btn_save.setOnClickListener(new View.OnClickListener() {
        @Override
         public void onClick(View v) {
         String model =et_model.getText().toString();
         double dpl = Double.parseDouble(et_dpl.getText().toString()) ;
         String color =et_color.getText().toString();
         Car car = new Car(model,color,dpl);
          boolean f= db.Insertcar(car);
                 if (f){
                     Toast.makeText(MainActivity.this, "تمت الاضافه بنجاح", Toast.LENGTH_SHORT).show();

           }else {
                     Toast.makeText(MainActivity.this, "حدث خطأ", Toast.LENGTH_SHORT).show();
                 }
         }
});


         btn_restore.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 ArrayList<Car> c = db.getcar("2018");
                for(Car car :c){
                    Toast.makeText(MainActivity.this, car.getModel()+car.getId()+"", Toast.LENGTH_SHORT).show();
                }

             }
         });

    }//end oncreate()
}//end class