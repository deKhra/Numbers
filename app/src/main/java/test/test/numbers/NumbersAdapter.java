package test.test.numbers;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class NumbersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    static final int ITEM_CARD = R.layout.item;
    private List<String> numbers;
    private Context context;
    private View.OnClickListener onClickListener;

    public NumbersAdapter(List<String> numbersList, View.OnClickListener onClickListener) {numbers = numbersList; this.onClickListener = onClickListener;}
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(ITEM_CARD, parent, false);
        return new ItemViewHolder(itemView, onClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ItemViewHolder itemHolder = ((ItemViewHolder) viewHolder);
        itemHolder.text.setText(numbers.get(i).toString());
        if ((i+1)%2 == 0){itemHolder.text.setTextColor(Color.RED);}
        else {itemHolder.text.setTextColor(Color.BLUE);}
    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }
    
    class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView text;
        public ItemViewHolder(@NonNull View itemView, View.OnClickListener onClickListener) {
            super(itemView);
            text = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(onClickListener);
        }
    }
}
