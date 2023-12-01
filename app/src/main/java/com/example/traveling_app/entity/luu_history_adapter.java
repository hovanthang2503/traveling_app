package com.example.traveling_app.entity;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.traveling_app.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class luu_history_adapter extends RecyclerView.Adapter<luu_history_adapter.myviewholder> {
    Context context;
    ArrayList<luu_history_obj> list;

    public luu_history_adapter(Context context, ArrayList<luu_history_obj> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_luu_lichsu,parent,false);
        return new luu_history_adapter.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        luu_history_obj luuHistoryObj = list.get(position);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("tours");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = snapshot.child(luuHistoryObj.getIdtour()).child("name").getValue(String.class);
                holder.name.setText(name);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        holder.price.setText(luuHistoryObj.getPrice() + "");
        holder.dateStart.setText(luuHistoryObj.getStartDate());
        holder.dateEnd.setText(luuHistoryObj.getEndDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder{
        private TextView name, price, dateStart, dateEnd;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            dateStart = itemView.findViewById(R.id.dateStart);
            dateEnd = itemView.findViewById(R.id.dateEnd);
        }
    }
}
