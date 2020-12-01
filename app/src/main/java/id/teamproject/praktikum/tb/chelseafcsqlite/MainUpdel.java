package id.teamproject.praktikum.tb.chelseafcsqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Sname, Sdob, Sbirthplace, Sheight, Sweight, Sposition, Snumber;
    private EditText Eid, Ename, Edob, Ebirthplace, Eheight, Eweight, Eposition, Enumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Sname = i.getStringExtra("Iname");
        Sdob = i.getStringExtra("Idob");
        Sbirthplace = i.getStringExtra("Ibirthplace");
        Sheight = i.getStringExtra("Iheight");
        Sweight = i.getStringExtra("Iweight");
        Sposition = i.getStringExtra("Iposition");
        Snumber = i.getStringExtra("Inumber");

        Ename = (EditText) findViewById(R.id.updel_name);
        Edob = (EditText) findViewById(R.id.updel_dob);
        Ebirthplace = (EditText) findViewById(R.id.updel_birthplace);
        Eheight = (EditText) findViewById(R.id.updel_height);
        Eweight = (EditText) findViewById(R.id.updel_weight);
        Eposition = (EditText) findViewById(R.id.updel_position);
        Enumber = (EditText) findViewById(R.id.updel_number);

        Ename.setText(Sname);
        Edob.setText(Sdob);
        Ebirthplace.setText(Sbirthplace);
        Eheight.setText(Sheight);
        Eweight.setText(Sweight);
        Eposition.setText(Sposition);
        Enumber.setText(Snumber);

        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
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
                    Toast.makeText(MainUpdel.this, "This field required",
                            Toast.LENGTH_SHORT).show();
                } else if (Sdob.equals("")){
                    Edob.requestFocus();
                    Toast.makeText(MainUpdel.this, "This field required",
                            Toast.LENGTH_SHORT).show();
                } else if (Sbirthplace.equals("")){
                    Ebirthplace.requestFocus();
                    Toast.makeText(MainUpdel.this, "This field required",
                            Toast.LENGTH_SHORT).show();
                } else if (Sheight.equals("")){
                    Eheight.requestFocus();
                    Toast.makeText(MainUpdel.this, "This field required",
                            Toast.LENGTH_SHORT).show();
                } else if (Sweight.equals("")){
                    Eweight.requestFocus();
                    Toast.makeText(MainUpdel.this, "This field required",
                            Toast.LENGTH_SHORT).show();
                } else if (Sposition.equals("")){
                    Eposition.requestFocus();
                    Toast.makeText(MainUpdel.this, "This field required",
                            Toast.LENGTH_SHORT).show();
                } else if (Snumber.equals("")){
                    Enumber.requestFocus();
                    Toast.makeText(MainUpdel.this, "This field required",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    db.UpdatePlayer(new Player(Sid, Sname, Sdob, Sbirthplace, Sheight, Sweight, Sposition, Snumber));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeletePlayer(new Player(Sid, Sname, Sdob, Sbirthplace, Sheight, Sweight, Sposition, Snumber));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
