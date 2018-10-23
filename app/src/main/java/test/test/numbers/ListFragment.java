package test.test.numbers;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    static final int COLUMN_COUNT = 3;
    NumbersAdapter adapter;
    private CooperationListener cooperationListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        cooperationListener = (CooperationListener) activity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_table, container, false);
        List<String> numbers = new ArrayList<>();
        for (int i = 1; i<101;i++){numbers.add(String.valueOf(i));}
        RecyclerView view = (RecyclerView) rootView.findViewById(R.id.item_container);
        view.setLayoutManager(new GridLayoutManager(getContext(), COLUMN_COUNT));
        adapter = new NumbersAdapter(numbers,new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cooperationListener.onCooperation(((TextView)view.findViewById(R.id.textView)).getText().toString());
            }
        });
        view.setAdapter(adapter);
        return rootView;
    }
    public interface CooperationListener {
        void onCooperation(String cooperationText);
    }
}
