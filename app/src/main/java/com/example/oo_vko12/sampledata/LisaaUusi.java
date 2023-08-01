package com.example.oo_vko12.sampledata;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.oo_vko12.Item;
import com.example.oo_vko12.ItemListAdapter;
import com.example.oo_vko12.ItemStorage;
import com.example.oo_vko12.MainActivity;
import com.example.oo_vko12.R;

public class LisaaUusi extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lisaa_uusi, container, false);

        //Get reference to Lista (in order to update the list)
        Fragment f = getActivity().getSupportFragmentManager().findFragmentByTag("f1");
        //System.out.println("Fragment with tag '"+"f1"+"' is "+f);
        //Fragment f = ((MainActivity) getActivity()).getFragments().get(1);

        /*
        TBA:
        -Toast when added in order to notify the user that something happened
        -clear the edit text field after adding and it was done so successfully
         */
        EditText et = view.findViewById(R.id.etItemContent);
        CheckBox cb = view.findViewById(R.id.cbTarkea);

        //Add items
        view.findViewById(R.id.btnAddItem).setOnClickListener(_view -> {
            ItemStorage.getInstance().addItem(
                        new Item(String.valueOf(et.getText()))
            );

            //when submitting check the checkbox and apply
            if(cb.isChecked()) {
                TextView tv = ((MainActivity) getActivity()).findViewById(R.id.tvTarkeat);
                tv.setText(et.getText());
            }

            ((Lista) f).getAdapter().notifyDataSetChanged();

            //print posted
            Toast.makeText(getActivity(),"Added to list",Toast.LENGTH_SHORT);
            et.setText("");
        });

        return view;
    }

}