package test.test.numbers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ListFragment.CooperationListener  {
    static final int COLUMN_COUNT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment list = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        transaction.add(R.id.fragment_container,new ListFragment());
        transaction.commit();
    }

    @Override
    public void onCooperation(String cooperationText) {
        NumberFragment fr = new NumberFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(NumberFragment.ITEM_NUMBER, Integer.parseInt(cooperationText));
        fr.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container,fr,NumberFragment.NUMBER_FRAGMENT).addToBackStack(NumberFragment.NUMBER_FRAGMENT);
        transaction.commit();
    }
}
