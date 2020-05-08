package com.example.worklist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.worklist.adaptador.MyAdapterList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView myList;
    List<String> signatures;//=new ArrayList<String>(Arrays.asList("Planificacón TIC","Fcaultativa II","Investigación Aplicada"));//
    MyAdapterList Adapter;
    EditText AsignaturaText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList=(ListView)findViewById(R.id.ListAsig);
        myList.setOnCreateContextMenuListener(this);
        fillList();
        selectItemList();
        AsignaturaText=(EditText)findViewById(R.id.editText_Asig);
    }

    void fillList(){

        signatures= new ArrayList<String>();

        signatures.add("Planificacón TIC");
        signatures.add("Facultativa II");
        signatures.add("Investigación Aplicada");
        Adapter=new MyAdapterList(this, R.layout.item_list, signatures);
        myList.setAdapter(Adapter);
    }

    void selectItemList(){

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText( MainActivity.this, "Item selecionado"+signatures.get(position), Toast.LENGTH_LONG).show();
            }
        });;
    }
    void Registrar(String asignatura){

        signatures.add(asignatura);
        AsignaturaText.setText("");

    }

    public void Asignatura_Oncliclk(View view){

        String asignatura=AsignaturaText.getText().toString();
        Registrar(asignatura);
    }


}
