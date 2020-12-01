package id.teamproject.praktikum.tb.chelseafcsqlite;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Player> playerItems;

    public CustomListAdapter(Activity activity, List<Player> playerItems) {
        this.activity = activity;
        this.playerItems = playerItems;
    }
    @Override
    public int getCount() {
        return playerItems.size();
    }

    @Override
    public Object getItem(int location) {
        return  playerItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView name = (TextView) convertView.findViewById(R.id.text_name);
        TextView dob = (TextView) convertView.findViewById(R.id.text_dob);
        TextView birthplace = (TextView) convertView.findViewById(R.id.text_birthplace);
        TextView height = (TextView) convertView.findViewById(R.id.text_height);
        TextView weight = (TextView) convertView.findViewById(R.id.text_weight);
        TextView position1 = (TextView) convertView.findViewById(R.id.text_position);
        TextView number = (TextView) convertView.findViewById(R.id.text_number);

        Player m = playerItems.get(position);
        name.setText("Name : "+ m.get_name());
        dob.setText("Date of Birth : "+ m.get_dob());
        birthplace.setText("Birthplace : "+ m.get_birthplace());
        height.setText("Height : "+ m.get_height());
        weight.setText("Weight : "+ m.get_weight());
        position1.setText("Position : "+ m.get_position());
        number.setText("Number : "+ m.get_number());
        return convertView;
    }
}
