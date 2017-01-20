package com.example.a46453895j.firebase;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> Afrase;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Afrase = new ArrayList<>();
        adapter= new ArrayAdapter<String>(this,R.layout.frase,R.id.textView,Afrase);

        ListView Lvfrase=(ListView) findViewById(R.id.Lvfrase) ;
        Button boton=(Button) findViewById(R.id.button);
        final EditText frase=(EditText) findViewById(R.id.Etfrase);

        Lvfrase.setAdapter(adapter);
        boton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                adapter.add(frase.getText().toString());
            }
        });
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
