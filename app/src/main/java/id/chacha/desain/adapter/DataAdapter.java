package id.chacha.desain.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import id.chacha.desain.R;

import java.util.ArrayList;

public class DataAdapter  extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<String> kota;

    public DataAdapter(ArrayList<String> kota){
        this.kota = kota;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.txtkota.setText(kota.get(i));
    }

    @Override
    public int getItemCount() {
        return kota.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtkota;
        public ViewHolder(View view) {
            super(view);

            txtkota = (TextView)view.findViewById(R.id.nama_kota);
        }
    }
}