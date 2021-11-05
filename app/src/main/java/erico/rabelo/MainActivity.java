package erico.rabelo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import erico.rabelo.activies.ActivitySom;
import erico.rabelo.activies.ActivitySpinnerRadioButton;
import erico.rabelo.activies.ActivityTarefa;

public class MainActivity extends AppCompatActivity {

    private Button btToggleButton;//toggle button
    private Button btSpinner;//spinner
    private Button btRadioButton;//spinner

    //Como usar um EditText
    private EditText eText;
    private Button btn;

    private Button btSom;//som

    private Button button1;//dropdown popup menu

    private Button btLongClick;
    private TextView txLongClick;

    private Button btImg;
    private TextView txImg;


    private Button btTabs;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toggle button
        this.btToggleButton = (Button) findViewById(R.id.btToggleButton);

        this.btToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityTarefa.class);
                startActivity(intent);
            }
        });//fim toggle	button

        //spinner e radiobutton
        this.btSpinner = (Button) findViewById(R.id.btSpinner);

        this.btSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivitySpinnerRadioButton.class);
                startActivity(intent);
            }
        });//fim spinner e radiobutton

        //som
        this.btSom = (Button) findViewById(R.id.btSom);
        this.btSom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivitySom.class);
                startActivity(intent);
            }
        });
        //som fim

        //drodown popup menu
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(MainActivity.this, button1);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.menu_dropdown_popup, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                MainActivity.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        return true;
                    }
                });

                popup.show(); //showing popup menu
            }
        }); //closing the setOnClickListener method
        //fim dropdown popup menu

        //longclick
        this.btLongClick = (Button) findViewById(R.id.btLongClick);
        txLongClick = (TextView) findViewById(R.id.txLongClick);

        this.btLongClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Intent intent = new Intent(MainActivity.this, LongPress.class);
              //  startActivity(intent);
                txLongClick.setText("On click listener");
            }
        });

        this.btLongClick.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this, "Long Click", Toast.LENGTH_SHORT).show();
                return false;
            }
        });//fim longclick

        //img
        this.btImg = (Button) findViewById(R.id.btImg);

        this.btImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txImg.setBackgroundResource(R.drawable.android);

            }
        });//fim img

        //tabs
        this.btTabs = (Button) findViewById(R.id.btTabs);
        this.btTabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent intent = new Intent(MainActivity.this, );
               // startActivity(intent);
            }
        });
        //tabs fim

        //ListView - ArrayList - ArrayAdapter
        ListView lista = (ListView) findViewById(R.id.lvEquipes);
        final ArrayList<String> equipes = preencherDados();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, equipes);
        lista.setAdapter(arrayAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(), "Equipes: " + equipes.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
        //ListView - ArrayList - ArrayAdapter fim

    }//fim oncreate

    private ArrayList<String> preencherDados(){
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("Mercerdes");
        dados.add("Ferrari");
        dados.add("Red Bull");
        return dados;
    }

    //options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemSalvar:
                Toast.makeText(MainActivity.this, "Você Selecionou: Salvar ", Toast.LENGTH_SHORT).show();
                break;

            case R.id.itemEditar:
                Toast.makeText(MainActivity.this, "Você Selecionou: Editar ", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    //fim options menu
}