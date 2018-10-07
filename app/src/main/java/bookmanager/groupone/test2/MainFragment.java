package bookmanager.groupone.test2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.main_fragment_listview, container, false);


        ArrayList<Book> aList = SimpleBookManager.getInstance().library.getAllBooks();

        final ListView listView = (ListView) root.findViewById(R.id.book_list);

        ArrayAdapter<Book> adapter = new ArrayAdapter<Book>(this.getContext(),android.R.layout.simple_list_item_1,aList);

        listView.setAdapter(adapter);

        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Object o = listView.getItemAtPosition(position);
                Intent intent = new Intent(getActivity(), BookView.class);
                intent.putExtra("pos", position);
                startActivity(intent);

            }
        });

        return root;
    }
/*
    private AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            Intent intent = new Intent(this.getContext(), DetailActivity.class);
            intent.putExtra("item", this.mAdapter.getItem(position - 1));
            startActivity(intent);
        }
    };*/
}

