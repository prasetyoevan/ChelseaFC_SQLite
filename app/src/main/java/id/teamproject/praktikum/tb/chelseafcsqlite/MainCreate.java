package id.teamproject.praktikum.tb.chelseafcsqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Ename, Edob, Ebirthplace, Eheight, Eweight, Eposition, Enumber;
    private String Sname, Sdob, Sbirthplace, Sheight, Sweight, Sposition, Snumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Ename = (EditText) findViewById(R.id.create_name);
        Edob = (EditText) findViewById(R.id.create_dob);
        Ebirthplace = (EditText) findViewById(R.id.create_birthplace);
        Eheight = (EditText) findViewById(R.id.create_height);
        Eweight = (EditText) findViewById(R.id.create_weight);
        Eposition = (EditText) findViewById(R.id.create_position);
        Enumber = (EditText) findViewById(R.id.create_number);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sname = String.valueOf(Ename.getText());
                Sdob = String.valueOf(Edob.getText());
                Sbirthplace = String.valueOf(Ebirthplace.getText());
                Sheight = String.valueOf(Eheight.getText());
                Sweight = String.valueOf(Eweight.getText());
                Sposition = String.valueOf(Eposition.getText());
                Snumber = String.valueOf(Enumber.getText());
                if (Sname.equals("")){
                    Ename.requestFocus();
                    Toast.makeText(MainCreate.this, "This field required",
                            Toast.LENGTH_SHORT).show();
                } else if (Sdob.equals("")){
                    Edob.requestFocus();
                    Toast.makeText(MainCreate.this, "This field required",
                            Toast.LENGTH_SHORT).show();
                } else if (Sbirthplace.equals("")){
                    Ebirthplace.requestFocus();
                    Toast.makeText(MainCreate.this, "This field required",
                            Toast.LENGTH_SHORT).show();
                } else if (Sheight.equals("")){
                    Eheight.requestFocus();
                    Toast.makeText(MainCreate.this, "This field required",
                            Toast.LENGTH_SHORT).show();
                } else if (Sweight.equals("")){
                    Eweight.requestFocus();
                    Toast.makeText(MainCreate.this, "This field required",
                            Toast.LENGTH_SHORT).show();
                } else if (Sposition.equals("")){
                    Eposition.requestFocus();
                    Toast.makeText(MainCreate.this, "This field required",
                            Toast.LENGTH_SHORT).show();
                } else if (Snumber.equals("")){
                    Enumber.requestFocus();
                    Toast.makeText(MainCreate.this, "This field required",
                            Toast.LENGTH_SHORT).show();
                }

                else {
                    Ename.setText("");
                    Edob.setText("");
                    Ebirthplace.setText("");
                    Eheight.setText("");
                    Eweight.setText("");
                    Eposition.setText("");
                    Enumber.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreatePlayer(new Player(null, Sname, Sdob, Sbirthplace, Sheight, Sweight, Sposition, Snumber));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}

