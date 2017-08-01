package com.example.andriod.profile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import static com.example.andriod.profile.R.id.android_material_design_spinner1;
import static com.example.andriod.profile.R.id.android_material_design_spinner2;


public class fourFragment extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    EditText age,ht1,ht2,wt;
    TextView blue,green,yellow,orange,red,wtdis,ideal,category,resview;
    Button female,male,result;
    int agev,flag,iflag;
    String hselected,wselected,ageV,ht1V,ht2V,wtV=null;
    double ls,u,ht,ht1v,ht2v,wtv,bmi;

    String [] SPINNERLIST1={"FT + IN","CM"};
    String [] SPINNERLIST2={"LB","KG"};

    public static fourFragment newInstance() {
        fourFragment fragment = new fourFragment();
               return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_four, container, false);
        blue=(TextView)v.findViewById(R.id.blue);
        green=(TextView)v.findViewById(R.id.green);
        yellow=(TextView)v.findViewById(R.id.yellow);
        orange=(TextView)v.findViewById(R.id.orange);
        red=(TextView)v.findViewById(R.id.red);
        wtdis=(TextView)v.findViewById(R.id.wtdis);
        ideal=(TextView)v.findViewById(R.id.ideal);
        resview=(TextView)v.findViewById(R.id.resview);
        category=(TextView)v.findViewById(R.id.category);

        age=(EditText)v.findViewById(R.id.age);
        ht1=(EditText)v.findViewById(R.id.ht1);
        ht2=(EditText)v.findViewById(R.id.ht2);
        wt=(EditText)v.findViewById(R.id.wt);
        female=(Button)v.findViewById(R.id.female);
        male=(Button)v.findViewById(R.id.male);
        result=(Button)v.findViewById(R.id.result);

        MaterialBetterSpinner betterSpinner1= (MaterialBetterSpinner)v.findViewById(android_material_design_spinner1);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, SPINNERLIST1);
        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        betterSpinner1.setAdapter(adapter1);
        MaterialBetterSpinner betterSpinner2= (MaterialBetterSpinner)v.findViewById(android_material_design_spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, SPINNERLIST2);
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        betterSpinner2.setAdapter(adapter2);

        female.setOnClickListener(this);
        male.setOnClickListener(this);

        result.setOnClickListener(this);


        return v;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        switch (adapterView.getId()){
            case android_material_design_spinner1:
                hselected=adapterView.getItemAtPosition(i).toString();
                break;

            case android_material_design_spinner2:
                wselected=adapterView.getItemAtPosition(i).toString();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.female:
                flag=1;
                break;

            case R.id.male:
                flag=2;
                break;

            case R.id.result:
                ageV=age.getText().toString();
                ht1V=ht1.getText().toString();
                ht2V=ht2.getText().toString();
                wtV=wt.getText().toString();

                agev=Integer.parseInt(ageV);
                ht1v=Integer.parseInt(ht1V);
                ht2v=Integer.parseInt(ht2V);
                wtv=Integer.parseInt(wtV);

                if(hselected=="FT + IN" && wselected=="LB"){
                        iflag=1;
                        ht1v=ht1v*12;
                        if(ht2V==null){
                            ht2v=0;
                        }
                        ht=ht1v+ht2v;
                        bmi=(wtv/(ht*ht))*703;
                        resview.setText((int) bmi);
                        wtdis.setText("LB");
                    }
                    else if (hselected=="CM" && wselected=="KG"){
                        iflag=2;
                        ht=ht1v/100;
                        bmi=wtv/(ht*ht);
                        resview.setText((int) bmi);
                        wtdis.setText("KG");
                    }
                    if(flag==1){
                        if(agev>=2 && agev<=19){
                            blue.setText("< 16.9");
                            green.setText("16.9 - 25.1");
                            yellow.setText("25.2 - 29");
                            orange.setText("29.1 - 36.9");
                            red.setText("> 36.9");
                            if(iflag==1) {
                                ls =((16.9 * ht * ht) / 703);
                                u = (25.1 * ht * ht) / 703;
                                ideal.setText(ls + " - " + u);
                            }
                            else if(iflag==2){
                                ls = (16.9 * ht * ht);
                                u = (25.1 * ht * ht);
                                ideal.setText(ls + " - " + u);
                            }

                        }

                        else if (agev>=20){
                            blue.setText("< 19");
                            green.setText("19 - 24");
                            yellow.setText("25 - 29");
                            orange.setText("30-39");
                            red.setText("> 39");
                            if(iflag==1) {
                                ls = ((19 * ht* ht) / 703);
                                u = (24 * ht * ht) / 703;
                                ideal.setText(ls + " - " + u);
                            }
                            else if(iflag==2){
                                ls = (19 * ht * ht);
                                u = (24 * ht * ht);
                                ideal.setText(ls + " - " + u);
                            }
                        }
                    }
                    else if(flag==2){
                        if(agev>=2 && agev<=19){
                            blue.setText("< 17.9");
                            green.setText("17.9 - 25.6");
                            yellow.setText("25.7 - 29.2");
                            orange.setText("29.3 - 36.1");
                            red.setText("> 36.1");
                            if(iflag==1) {
                                ls = ((17.9 * ht * ht) / 703);
                                u = (25.6 * ht * ht) / 703;
                                ideal.setText(ls + " - " + u);
                            }
                            else if(iflag==2){
                                ls = (17.9 * ht * ht);
                                u = (25.6 * ht * ht);
                                ideal.setText(ls + " - " + u);
                            }
                        }

                        else if (agev>=20){
                            blue.setText("< 20.85");
                            green.setText("20.85 - 26.84");
                            yellow.setText("26.85 - 30.85");
                            orange.setText("30.86-40.85");
                            red.setText("> 40.85");
                            if(iflag==1) {
                                ls =((20.85 * ht * ht) / 703);
                                u = (26.84 * ht * ht) / 703;
                                ideal.setText(ls + " - " + u);
                            }
                            else if(iflag==2){
                                ls = (20.85 * ht * ht);
                                u = (26.84 * ht * ht);
                                ideal.setText(ls + " - " + u);
                            }
                        }


                    }
        }

    }
}
