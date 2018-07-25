package com.my.hp.sample;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {

  private   Spinner sp;
    private  Spinner sp1;
    private  String title[];
    private  String description[];
    private String rating[];
    private Integer burger[] = {R.drawable.burger,R.drawable.mac,R.drawable.pp};
    private  ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=(Spinner) findViewById(R.id.spinner);
        sp1=(Spinner) findViewById(R.id.spinner1);
        ArrayAdapter adp=ArrayAdapter.createFromResource(this,R.array.data,android.R.layout.simple_spinner_item);
        sp.setAdapter(adp);
        ArrayAdapter adp1=ArrayAdapter.createFromResource(this,R.array.data1,android.R.layout.simple_spinner_item);
        sp1.setAdapter(adp1);

        Resources rs = getResources();
        String title[] = rs.getStringArray(R.array.title);
        String description[] = rs.getStringArray(R.array.description);
        String rating[] = rs.getStringArray(R.array.rating);


        lv = (ListView) findViewById(R.id.listview);
        khan adapter=new khan(this,title,burger,description,rating);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener ( new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView <?> adapterView, View view,
                                    int position, long l) {
                if(position==0) {
                    Intent myintent =new Intent (view.getContext(),Activity2.class);
                    startActivityForResult ( myintent,0 );

                }
                if(position==1) {
                    Intent myintent =new Intent (view.getContext(),Activity2.class);
                    startActivityForResult ( myintent,1 );

                }
                if(position==2) {
                    Intent myintent =new Intent (view.getContext(),Activity2.class);
                    startActivityForResult ( myintent,2 );

                }
            }
        } );

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom1);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);




    }
}
class khan extends ArrayAdapter<String>
{

    Context context;
    Integer burger[];
    String titlearray[];
    String descriptionarray[];
    String star[];
    khan(Context c, String[] titles, Integer[] imgs, String[] descriptions, String[] rating)
    {
        super(c,R.layout.single,R.id.title,titles);
        this.context=c;
        this.burger =imgs;
        this.titlearray=titles;
        this.descriptionarray=descriptions;
        this.star=rating;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.single,parent,false);

        ImageView img=(ImageView)row.findViewById(R.id.burger);
        TextView tt=(TextView)row.findViewById(R.id.title);
        TextView tt1=(TextView)row.findViewById(R.id.description);
        TextView tt2=(TextView)row.findViewById(R.id.rating);

        img.setImageResource(burger[position]);
        tt.setText(titlearray[position]);
        tt1.setText(descriptionarray[position]);
        tt2.setText(star[position]);



        return row;
    }

}

