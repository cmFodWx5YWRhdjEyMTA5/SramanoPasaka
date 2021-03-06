package com.sramanopasaka.sipanionline.sadhumargi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sramanopasaka.sipanionline.sadhumargi.model.NanenshSahitya;
import com.sramanopasaka.sipanionline.sadhumargi.model.RamSahitya;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by apple on 15/02/18.
 */

class ThreeFragGridAdapter extends BaseAdapter {

    ArrayList<NanenshSahitya> naneshsahityArrayList;
    Context context;
    ImageLoader imageLoader;

    public ThreeFragGridAdapter(FragmentActivity activity, ArrayList<NanenshSahitya> arrayList) {

        this.context = activity;
        this.naneshsahityArrayList = arrayList;
        imageLoader = new ImageLoader(context);

    }

    @Override
    public int getCount() {
        return naneshsahityArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        Typeface type = Typeface.createFromAsset(context.getAssets(),"fonts/KrutiDev010 .TTF");

        View grid;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final NanenshSahitya model = naneshsahityArrayList.get(i);

//        final ViewHolder holder =null;

        if (view == null) {

            grid = new View(context);

            grid = inflater.inflate(R.layout.activity_three_frag_adapter, null);

            TextView txtTitle = (TextView) grid.findViewById(R.id.threefrag_txt_date);
            ImageView imageView = (ImageView)grid.findViewById(R.id.threefrag_image);
            txtTitle.setText(naneshsahityArrayList.get(i).getTitle());
            txtTitle.setTypeface(type);
            final String id = model.getNane_sah_id();
            String url2=model.getImg_link();
            imageLoader.DisplayImage(url2, imageView );

        } else {
            grid = (View) view;
        }


        final View finalGrid = grid;

        grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final boolean isConnected=ConnectivityReceiver.isConnected();

                if(isConnected)
                {
                    String encode=naneshsahityArrayList.get(i).getNane_sah_id();
                    try {
                        String query = URLEncoder.encode(encode, "utf-8");
                        Log.e("Encode values","Success///"+query);
                        String a1=naneshsahityArrayList.get(i).getDate();
                        Intent i1 = new Intent(context, WebviewSahitya.class);
                        i1.putExtra("BookTitle",encode);
                        i1.putExtra("BookType","N");
                        context.startActivity(i1);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                else
                {
                    Snackbar snackbar1 = Snackbar.make(view, "Sorry! Not connected to internet", Snackbar.LENGTH_SHORT);
                    View sbView = snackbar1.getView();
                    TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setTextColor(Color.RED);
                    snackbar1.show();
                }
            }
        });
        return grid;
    }
}
