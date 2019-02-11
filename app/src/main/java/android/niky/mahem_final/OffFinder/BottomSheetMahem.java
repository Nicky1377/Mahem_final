package android.niky.mahem_final.OffFinder;

import android.niky.mahem_final.R;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class BottomSheetMahem extends AppCompatActivity {

    private Button Open;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_sheet_mahem);

        Open=(Button)findViewById(R.id.btn);
        Open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bottom_Sheet bottom_sheet=new Bottom_Sheet(getBaseContext());
                bottom_sheet.show(getSupportFragmentManager(),"");
                ImageView imageView=new ImageView(BottomSheetMahem.this);
                imageView.setImageResource(R.drawable.logo);
                RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.addRule(RelativeLayout.ALIGN_TOP,R.layout.near_me_bottom_sheet);
                imageView.setLayoutParams(params);
            }
        });

    }
}
