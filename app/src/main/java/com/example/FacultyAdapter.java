package com.example;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fp.R;

import java.util.List;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fp.R;

import java.util.List;

public class FacultyAdapter extends RecyclerView.Adapter<FacultyAdapter.ViewHolder> {
    private List<Faculty> facultyList;
    private Context context;

    public FacultyAdapter(Context context, List<Faculty> facultyList) {
        this.context = context;
        this.facultyList = facultyList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.faculty_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Faculty faculty = facultyList.get(position);
        if (faculty == null) return;

        holder.nameTextView.setText("Name: " + safeText(faculty.getName()));
        holder.ecodeTextView.setText("E-Code: " + safeText(faculty.getEcode()));
        holder.emailTextView.setText("Email: " + safeText(faculty.getEmail()));
        holder.contactTextView.setText("Contact: " + safeText(faculty.getContact()));
        holder.coordinatorTextView.setText("Coordinator: " + safeText(faculty.getCoordinator()));
        holder.yearTextView.setText("Year: " + safeText(faculty.getYear()));
        holder.responsibilityTextView.setText("Responsibility: " + safeText(faculty.getResponsibility()));
        holder.venueTextView.setText("Seating Venue: " + safeText(faculty.getSeatingVenue()));
        holder.blockTextView.setText("Block: " + safeText(faculty.getBlock()));
    }

    @Override
    public int getItemCount() {
        return facultyList != null ? facultyList.size() : 0;
    }

    public void updateData(List<Faculty> newList) {
        if (newList == null) return;
        facultyList.clear();
        facultyList.addAll(newList);
        notifyDataSetChanged();
    }

    private String safeText(String input) {
        return input != null && !input.trim().isEmpty() ? input : "N/A";
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, ecodeTextView, emailTextView, contactTextView,
                coordinatorTextView, yearTextView, responsibilityTextView,
                venueTextView, blockTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            ecodeTextView = itemView.findViewById(R.id.ecodeTextView);
            emailTextView = itemView.findViewById(R.id.emailTextView);
            contactTextView = itemView.findViewById(R.id.contactTextView);
            coordinatorTextView = itemView.findViewById(R.id.coordinatorTextView);
            yearTextView = itemView.findViewById(R.id.yearTextView);
            responsibilityTextView = itemView.findViewById(R.id.responsibilityTextView);
            venueTextView = itemView.findViewById(R.id.venueTextView);
            blockTextView = itemView.findViewById(R.id.blockTextView);
        }
    }
}
