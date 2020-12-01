package id.teamproject.praktikum.tb.chelseafcsqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Player> ListPlayer = new ArrayList<Player>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListPlayer );
        mListView = (ListView) findViewById(R.id.list_player);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListPlayer.clear();
        List<Player> contacts = db.ReadPlayer();
        for (Player cn : contacts) {
            Player judulModel = new Player();
            judulModel.set_id(cn.get_id());
            judulModel.set_name(cn.get_name());
            judulModel.set_dob(cn.get_dob());
            judulModel.set_birthplace(cn.get_birthplace());
            judulModel.set_height(cn.get_height());
            judulModel.set_weight(cn.get_weight());
            judulModel.set_position(cn.get_position());
            judulModel.set_number(cn.get_number());
            ListPlayer.add(judulModel);
            if ((ListPlayer.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Player obj_itemDetails = (Player)o;
        String Sid = obj_itemDetails.get_id();
        String Sname = obj_itemDetails.get_name();
        String Sdob = obj_itemDetails.get_dob();
        String Sbirthplace = obj_itemDetails.get_birthplace();
        String Sheight = obj_itemDetails.get_height();
        String Sweight = obj_itemDetails.get_weight();
        String Sposition = obj_itemDetails.get_position();
        String Snumber = obj_itemDetails.get_number();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Iname", Sname);
        goUpdel.putExtra("Idob", Sdob);
        goUpdel.putExtra("Ibirthplace", Sbirthplace);
        goUpdel.putExtra("Iheight", Sheight);
        goUpdel.putExtra("Iweight", Sweight);
        goUpdel.putExtra("Iposition", Sposition);
        goUpdel.putExtra("Inumber", Snumber);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListPlayer.clear();
        mListView.setAdapter(adapter_off);
        List<Player> contacts = db.ReadPlayer();
        for (Player cn : contacts) {
            Player judulModel = new Player();
            judulModel.set_id(cn.get_id());
            judulModel.set_name(cn.get_name());
            judulModel.set_dob(cn.get_dob());
            judulModel.set_birthplace(cn.get_birthplace());
            judulModel.set_height(cn.get_height());
            judulModel.set_weight(cn.get_weight());
            judulModel.set_position(cn.get_position());
            judulModel.set_number(cn.get_number());
            ListPlayer.add(judulModel);
            if ((ListPlayer.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
