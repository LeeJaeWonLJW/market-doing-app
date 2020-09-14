package univ.customer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class VegAdt extends RecyclerView.Adapter<VegAdt.VegViewHolder> {
    String [] dataList;
    ViewFlipper vf;
    Context context;
    int gonum;
    public VegAdt(Context context, String [] list, ViewFlipper vf, int gonum){
        this.dataList = list;
        this.vf = vf;
        this.context = context;
        this.gonum = gonum;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return this.dataList.length;
    }

    @NonNull
    @Override
    public VegViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_element_veg, parent, false);
        VegViewHolder vh = new VegViewHolder(v,vf);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VegViewHolder holder, int position) {
        holder.idx.setText((position+1)+"");
        holder.title.setText(dataList[position]);
    }


    @Override
    public int getItemViewType(int i) {
        return 0;
    }

    public class VegViewHolder  extends RecyclerView.ViewHolder{
        TextView idx;
        TextView title;
        public VegViewHolder(View itemView, final ViewFlipper vf){
            super(itemView);
            idx = itemView.findViewById(R.id.element_veg_idx);
            title = itemView.findViewById(R.id.element_veg_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    vf.setDisplayedChild(gonum);
                }
            });
        }
    }
}
