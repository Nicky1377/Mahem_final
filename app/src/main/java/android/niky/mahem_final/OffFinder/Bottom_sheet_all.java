package android.niky.mahem_final.OffFinder;

import android.content.Context;
import android.content.Intent;
import android.niky.mahem_final.Add.SabtAgahi_Takhfif;
import android.niky.mahem_final.MenuItems.Off_Finder;
import android.niky.mahem_final.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by mohsal on 10/24/2018.
 */


public class Bottom_sheet_all extends BottomSheetDialogFragment {
    TextView all,weekend,cafe,arayesh,health,tafrih,LavazemJanebi,M_Arayesh,khodro,zivar,kitchen,teach,art,khadamat,hotel,lavazem_safar,
            pooshak,lavazemTahrir,other;

    private String select="0";
    private Boolean flag=false;


    public String getSelect() {
        return select;
    }

    public Boolean getFlag() {
        return flag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL,R.style.CustomBottomSheetTheme);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.all_takhfif_bottomsheet,container,false);

    /////maping
        all=(TextView)view. findViewById(R.id.btn);
        weekend=(TextView)view. findViewById(R.id.btn1);
        cafe=(TextView)view.findViewById(R.id.btn2);
        arayesh=(TextView)view.findViewById(R.id.btn3);
        health=(TextView)view.findViewById(R.id.btn4);
        tafrih=(TextView)view.findViewById(R.id.btn5);
        LavazemJanebi=(TextView)view.findViewById(R.id.btn6);
        M_Arayesh=(TextView)view.findViewById(R.id.btn7);
        khodro=(TextView)view.findViewById(R.id.btn8);
        zivar=(TextView)view.findViewById(R.id.btn9);
        kitchen=(TextView)view.findViewById(R.id.btn10);
        teach=(TextView)view.findViewById(R.id.btn11);
        art=(TextView)view.findViewById(R.id.btn12);
        khadamat=(TextView)view.findViewById(R.id.btn13);
        hotel=(TextView)view.findViewById(R.id.btn14);
        lavazem_safar=(TextView)view.findViewById(R.id.btn15);
        pooshak=(TextView)view.findViewById(R.id.btn16);
        lavazemTahrir=(TextView)view.findViewById(R.id.btn17);
        other=(TextView)view.findViewById(R.id.btn18);
//////////////////////////////



        all.setOnClickListener(new IntentClick("D",false));
        weekend.setOnClickListener(new IntentClick("D1",true));
        cafe.setOnClickListener(new IntentClick("D2", true));
        arayesh.setOnClickListener(new IntentClick("D3", true));
        health.setOnClickListener(new IntentClick("D4",true));
        tafrih.setOnClickListener(new IntentClick("D5", true));
        LavazemJanebi.setOnClickListener(new IntentClick("D6", true));
        M_Arayesh.setOnClickListener(new IntentClick("D7", true));
        khodro.setOnClickListener(new IntentClick("D8", true));
        zivar.setOnClickListener(new IntentClick("D9", true));
        kitchen.setOnClickListener(new IntentClick("D10", true));
        teach.setOnClickListener(new IntentClick("D11", true));
        art.setOnClickListener(new IntentClick("D12", true));
        khadamat.setOnClickListener(new IntentClick("D13", true));
        hotel.setOnClickListener(new IntentClick("D14", true));
        lavazem_safar.setOnClickListener(new IntentClick("D15", true));
        pooshak.setOnClickListener(new IntentClick("D16", true));
        lavazemTahrir.setOnClickListener(new IntentClick("D17", true));
        other.setOnClickListener(new IntentClick("D18", true));




        return view;
    }

    class IntentClick implements View.OnClickListener {

        private  Boolean f;
        private String ID;

        public IntentClick(String id,Boolean flg ) {

            ID=id;
            f=flg;
        }

        @Override
        public void onClick(View view) {
            flag=f;
            select=ID;
        }
    }

}

