package univ.customer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class SellAdt extends RecyclerView.Adapter<SellAdt.SellViewHolder> {
    String [][] dataList;
    ViewFlipper vf;
    Context context;
    int gonum;
    public SellAdt(Context context, String [][] list, ViewFlipper vf, int gonum){
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
    public SellViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_element_cart, parent, false);
        SellViewHolder vh = new SellViewHolder(v,vf);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull SellViewHolder holder, int position) {
        holder.seller.setText(dataList[position][0]);
        holder.product.setText(dataList[position][1]);
    }


    @Override
    public int getItemViewType(int i) {
        return 0;
    }

    public class SellViewHolder  extends RecyclerView.ViewHolder{
        TextView seller;
        TextView product;
        TextView cnt;
        public SellViewHolder(View itemView, final ViewFlipper vf){
            super(itemView);
            seller = itemView.findViewById(R.id.celler_title);
            product = itemView.findViewById(R.id.cell_product);
            cnt = itemView.findViewById(R.id.product_count);
            Button ubtn = itemView.findViewById(R.id.upbtn);
            ubtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    cnt.setText((Integer.parseInt(cnt.getText().toString()) + 1)+"");
                }
            });

            Button dbtn = itemView.findViewById(R.id.downbtn);
            dbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Integer.parseInt(cnt.getText().toString()) > 0)
                        cnt.setText((Integer.parseInt(cnt.getText().toString()) - 1)+"");
                }
            });
        }
    }
}
