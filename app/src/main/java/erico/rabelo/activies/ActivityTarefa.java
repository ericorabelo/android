package erico.rabelo.activies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import erico.rabelo.R;

public class ActivityTarefa extends AppCompatActivity {

    private EditText edtNomeMissao;
    private EditText edtDescricaoMissao;

    private Button btSalvarMissao;

    private ToggleButton btToggleButtonMissao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa);

        edtNomeMissao = (EditText) findViewById(R.id.edtNomeMissao);
        edtDescricaoMissao = (EditText) findViewById(R.id.edtDescricaoMissao);

        btSalvarMissao = (Button) findViewById(R.id.btSalvarMissao);

        addListenerOnButton();

         //autocomplete
        String str[]={"Arun","Mathev","Vishnu","Vishal","Arjun",
                "Arul","Balaji","Babu","Boopathy","Godwin","Nagaraj"};

        AutoCompleteTextView t1 = (AutoCompleteTextView)
                findViewById(R.id.autoCompleteTextView1);

        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,str);

        t1.setThreshold(1);
        t1.setAdapter(adp);
        //autocomplete fim

    }

    public void addListenerOnButton() {

        btToggleButtonMissao = (ToggleButton) findViewById(R.id.btToggleButtonMissao);

        btToggleButtonMissao.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                StringBuffer result = new StringBuffer();
                result.append("Missão: ").append(btToggleButtonMissao.getText());

                Toast.makeText(ActivityTarefa.this, result.toString(),
                        Toast.LENGTH_SHORT).show();

            }

        });
    }//fim addlistenerOnButton

}