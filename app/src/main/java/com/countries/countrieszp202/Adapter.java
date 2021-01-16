package com.countries.countrieszp202;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String ENTRY="com.countries.countrieszp202.ENTRY";
    private Context context;
    private LayoutInflater inflater;
    List<Countries> data;

    // create constructor to initialize context and data sent from SearchActivity
    public Adapter(Context context, List<Countries> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    // Inflate the layout when ViewHolder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.container_country, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // Get current position of item in RecyclerView to bind data and assign values from list
        MyHolder myHolder = (MyHolder) holder;
        Countries current = data.get(position);
        myHolder.textCountrie.setText("Country: "+current.getCountry());
        myHolder.textCode.setText("Code: " + current.getCode());
        myHolder.textPopulation.setText("Population: " + current.getPeople());
        myHolder.textArea.setText("Area: " + current.getArea());
    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textCountrie;
        TextView textCode;
        TextView textPopulation;
        TextView textArea;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            textCountrie = (TextView) itemView.findViewById(R.id.textCountrie);
            textCode = (TextView) itemView.findViewById(R.id.textCode);
            textPopulation = (TextView) itemView.findViewById(R.id.textPopulation);
            textArea = (TextView) itemView.findViewById(R.id.textArea);
            itemView.setOnClickListener(this);
        }

        // Click event for all items
        @Override
        public void onClick(View v) {

        }
    }
}
