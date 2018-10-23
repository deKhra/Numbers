package test.test.numbers;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NumberFragment extends Fragment {
    static final String ITEM_NUMBER = "n";
    static final String NUMBER_FRAGMENT = "nf";
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        View rootView = inflater.inflate(R.layout.number_layout, container, false);
        TextView text = (TextView) rootView.findViewById(R.id.number_view);
        int number = bundle.getInt(ITEM_NUMBER);
        text.setText(String.valueOf(number));
        if (number%2 == 0){text.setTextColor(Color.RED);}
        else {text.setTextColor(Color.BLUE);}
        return rootView;
    }
}
