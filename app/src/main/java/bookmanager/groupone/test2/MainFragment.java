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
        List<String> stringList = new ArrayList<>(aList.size());
        for (Book oneBook : aList) {
            stringList.add(oneBook.getTitle());
        }

        ListView listView = (ListView) root.findViewById(R.id.book_list);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this.getContext(), android.R.layout.simple_list_item_1, stringList );

        listView.setAdapter(arrayAdapter);

        /*listView.setOnItemClickListener(new AdapterView.onItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Intent appInfo = new Intent(this, DetailActivity.class);
                startActivity(appInfo);
            }
        });
        */

        return root;
    }
}

