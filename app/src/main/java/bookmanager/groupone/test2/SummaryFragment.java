package bookmanager.groupone.test2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SummaryFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_summary, container, false);

        SimpleBookManager library = SimpleBookManager.getInstance().library;

        TextView popTextView = (TextView) root.findViewById(R.id.popText);
        popTextView.setText(Integer.toString(library.count()));

        TextView totalcostTextView = (TextView) root.findViewById(R.id.totalCost);
        totalcostTextView.setText(library.getTotalCost() + " SEK");

        TextView maxPriceTextView = (TextView) root.findViewById(R.id.maxPrice);
        maxPriceTextView.setText(library.getMaxPrice() + " SEK");

        TextView minPriceTextView = (TextView) root.findViewById(R.id.minPrice);
        minPriceTextView.setText(library.getMinPrice() + " SEK");

        TextView meanPriceTextView = (TextView) root.findViewById(R.id.meanPrice);
        meanPriceTextView.setText((Float.toString(library.getMeanPrice()) + " SEK"));



        return root;
    }
}