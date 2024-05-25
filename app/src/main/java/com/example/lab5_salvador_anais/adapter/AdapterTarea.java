package com.example.lab5_salvador_anais.adapter;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import com.example.lab5_salvador_anais.R;
import com.example.lab5_salvador_anais.entity.Tarea;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class AdapterTarea extends RecyclerView.Adapter<AdapterTarea.TareaViewHolder>{

        private List<Tarea> tarea;
        private Context context;
        private OnItemClickListener listener;

        public static class TareaViewHolder extends RecyclerView.ViewHolder {
            public TextView tvTaskTitle, tvTaskDescription, tvTaskReminder;

            public TareaViewHolder(@NonNull View itemView, OnItemClickListener listener) {
                super(itemView);
                tvTaskTitle = itemView.findViewById(R.id.tvTaskTitle);
                tvTaskDescription = itemView.findViewById(R.id.tvTaskDescription);
                tvTaskReminder = itemView.findViewById(R.id.tvTaskReminder);

                itemView.setOnClickListener(v -> {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                });
            }
        }

        public AdapterTarea(List<Tarea> tarea, Context context) {
            this.tarea = tarea;
            this.context = context;
        }
        public interface OnItemClickListener{
            void onItemClick(int position);
        }

        public void setOnItemClickListener(OnItemClickListener listener) {
            this.listener = listener;
        }

        @NonNull
        @Override
        public TareaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_calendario, parent, false);
            return new TareaViewHolder(view, listener);
        }

        @Override
        public void onBindViewHolder(@NonNull TareaViewHolder holder, int position) {
            Tarea tarea1 = tarea.get(position);
            holder.tvTaskTitle.setText(tarea1.getTitle());
            holder.tvTaskDescription.setText(tarea1.getDescription());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
            String formattedDateTime = dateFormat.format(new Date(tarea1.getReminderTime()));
            holder.tvTaskReminder.setText(formattedDateTime);
        }

        @Override
        public int getItemCount() {
            return tarea.size();
        }
        public void deleteItem(int position) {
            tarea.remove(position);
            notifyItemRemoved(position);
        }
}
