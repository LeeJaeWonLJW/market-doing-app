package univ.customer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ViewFlipper;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DashBoardActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        final ViewFlipper flipper =findViewById(R.id.flipper);

        View pg1 = flipper.findViewById(R.id.page1);
        Button goVeg = pg1.findViewById((R.id.btn_goveg));
        goVeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.setDisplayedChild(1);
            }
        });

        View pg2 = flipper.findViewById(R.id.page2);
        RecyclerView recyclerView = pg2.findViewById(R.id.veg_list_view);
        String [] list = {"정동 대전청과 중도매인 ***번"};
        VegAdt va = new VegAdt(getBaseContext(),list,flipper,2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(va);

        View pg3 = flipper.findViewById(R.id.page3);
        RecyclerView recyclerView2 = pg3.findViewById(R.id.veg_list_seller_view);
        String [] list2 = {"파 한 단 /  가격 : ****원  / 국내산","양파 한 망 /  가격 : ****원  / 국내산","감자 한 박스 /  가격 : ****원  / 국내산"};
        VegAdt va2 = new VegAdt(getBaseContext(),list2,flipper,3);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setAdapter(va2);

        View pg4 = flipper.findViewById(R.id.page4);
        RecyclerView recyclerView3 = pg4.findViewById(R.id.list_cart_view);
        String [][] list3 = {{"정동 대전청과 중도매인 ***번","양파"},{"정동 대전청과 중도매인 ***번","당근"}};
        SellAdt va3 = new SellAdt(getBaseContext(),list3,flipper,4);
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));
        recyclerView3.setAdapter(va3);
        Button buybtn = pg4.findViewById(R.id.buybtn);
        buybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.setDisplayedChild(4);
            }
        });

    }




}
