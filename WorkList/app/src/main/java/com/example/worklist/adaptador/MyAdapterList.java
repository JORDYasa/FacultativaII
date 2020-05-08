package com.example.worklist.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.worklist.R;

import java.util.List;

public class MyAdapterList extends BaseAdapter {


    private Context context;
    private int layout;
    private List<String> signatures;

    public MyAdapterList(Context context, int layout, List<String> signatures) {
        this.context = context;
        this.layout = layout;
        this.signatures = signatures;
    }

    @Override
    public int getCount() {
        return signatures.size();
    }

    @Override
    public Object getItem(int position) {
        return signatures.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            LayoutInflater layoutInflater=LayoutInflater.from(this.context);
            convertView=layoutInflater.inflate(R.layout.item_list, null);
            holder=new ViewHolder();
            holder.textViewName=(TextView) convertView.findViewById(R.id.TextView_NomAsig);
            convertView.setTag(holder);
        }
        else{
            holder=(ViewHolder)convertView.getTag();
        }

        String current_Item=signatures.get(position);
        holder.textViewName.setText(current_Item);

        return convertView;
    }

    static class ViewHolder{
        private TextView textViewName;
    }
}
