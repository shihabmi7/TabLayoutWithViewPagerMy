package roy.tablayoutwithviewpager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFishFragment extends Fragment {

    FishListAdapter fishListAdapter;

    ArrayList<Fish> list = new ArrayList<>();

    public MyFishFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_game, container, false);

        // must fill the list here
        fishListAdapter = new FishListAdapter(getContext(), demoList());
        ListView listView = (ListView) rootView.findViewById(R.id.list_view_my_fish);
        listView.setAdapter(fishListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });


        return rootView;

    }

    ArrayList<Fish> demoList() {

        for (int i = 0; i <= 10; i++) {

            Fish fish = new Fish();
            fish.setFishName("Rui");
            fish.setPrice("200");
            fish.setQuantiity("1");
            fish.setQuantity_type("kg");
            list.add(fish);

        }

        return list;
    }


}
