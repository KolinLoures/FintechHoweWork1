package com.example.kolin.fintechhomework1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kolin on 04.10.2017.
 */

public class ContactsRecyclerAdapter extends RecyclerView.Adapter<ContactsRecyclerAdapter.ContactsViewHolder> {

    private ContactsRecyclerAdapter.ContractsRecyclerListener listener;

    private List<String> data = new ArrayList<>();

    @Override
    public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContactsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false));
    }

    @Override
    public void onBindViewHolder(ContactsViewHolder holder, int position) {
        String current = data.get(position);
        holder.textName.setText(current);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addData(List<String> data){
        int oldSize = this.data.size();
        this.data.addAll(data);
        notifyItemRangeInserted(oldSize, data.size());
    }

    public void delete(int pos){
        this.data.remove(pos);
        notifyItemRemoved(pos);
    }

    public void setListener(ContractsRecyclerListener listener) {
        this.listener = listener;
    }

    class ContactsViewHolder extends RecyclerView.ViewHolder {

        private TextView textName;
        private ImageButton btnInfo;
        private ImageButton btnDelete;

        public ContactsViewHolder(View itemView) {
            super(itemView);

            textName = itemView.findViewById(R.id.text_name);
            btnInfo = itemView.findViewById(R.id.image_btn_info);
            btnDelete = itemView.findViewById(R.id.image_btn_delete);

            btnInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null)
                        listener.onClickInfo(data.get(getAdapterPosition()), getAdapterPosition());
                }
            });

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    delete(getAdapterPosition());
                }
            });
        }
    }

    public interface ContractsRecyclerListener{
        void onClickInfo(String text, int pos);
    }
}
