package com.example.listviewmultb;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<String> {

    private int layout;

    public ListViewAdapter(Context context,int resource,List<String> objects){
        super(context,resource,objects);
        layout = resource;


    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder mainViewHolder = null;

        if(convertView ==null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(layout, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.icon = convertView.findViewById(R.id.imageView);
            viewHolder.button = convertView.findViewById(R.id.button);
            viewHolder.text = convertView.findViewById(R.id.textView);
            viewHolder.text.setText(getItem(position));
            viewHolder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(),"Followed user "+getItem(position),Toast.LENGTH_SHORT).show();

                }
            });
            convertView.setTag(viewHolder);
         }else{
            mainViewHolder = (ViewHolder) convertView.getTag();
            mainViewHolder.text.setText(getItem(position));
        }

        return convertView;

    }

}
