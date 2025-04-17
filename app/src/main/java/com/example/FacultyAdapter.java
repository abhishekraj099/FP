package com.example;


import android.content.Context;
import android.graphics.Color;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import com.example.fp.R;

public class FacultyAdapter extends RecyclerView.Adapter<FacultyAdapter.ViewHolder> {
    private List<Faculty> facultyList;
    private Context context;
    private SparseBooleanArray expandedItems; // To track expanded state

    public FacultyAdapter(Context context, List<Faculty> facultyList) {
        this.context = context;
        this.facultyList = facultyList;
        this.expandedItems = new SparseBooleanArray();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_faculty_collapsed, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Faculty faculty = facultyList.get(position);
        if (faculty == null) return;

        // Set card color based on position
        int[] cardColors = {
                Color.parseColor("#2196F3"), // Blue
                Color.parseColor("#9C27B0"), // Purple
                Color.parseColor("#009688"), // Teal
                Color.parseColor("#FF9800"), // Orange
                Color.parseColor("#4CAF50")  // Green
        };
        holder.cardContainer.setBackgroundColor(cardColors[position % cardColors.length]);

        // Always show name and E-code
        holder.nameTextView.setText(safeText(faculty.getName()));
        holder.ecodeTextView.setText("E-Code: " + safeText(faculty.getEcode()));

        // Set the remaining details
        holder.emailTextView.setText("Email: " + safeText(faculty.getEmail()));
        holder.contactTextView.setText("Contact: " + safeText(faculty.getContact()));
        holder.coordinatorTextView.setText("Coordinator: " + safeText(faculty.getCoordinator()));
        holder.yearTextView.setText("Year: " + safeText(faculty.getYear()));
        holder.responsibilityTextView.setText("Responsibility: " + safeText(faculty.getResponsibility()));
        holder.venueTextView.setText("Seating Venue: " + safeText(faculty.getSeatingVenue()));
        holder.blockTextView.setText("Block: " + safeText(faculty.getBlock()));

        // Manage expand/collapse state using expandedItems
        final boolean isExpanded = expandedItems.get(position, false);

        // Show or hide expanded content based on state
        holder.emailTextView.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.contactTextView.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.coordinatorTextView.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.yearTextView.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.responsibilityTextView.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.venueTextView.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.blockTextView.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

        // Set expand indicator icon if it exists
        if (holder.expandIcon != null) {
            holder.expandIcon.setImageResource(
                    isExpanded ? R.drawable.ic_expanded_less : R.drawable.ic_expanded_more
            );
        }

        // Set click listener to expand/collapse card
        final int pos = position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle expanded state
                boolean expanded = expandedItems.get(pos, false);
                expandedItems.put(pos, !expanded);

                if (!expanded) {
                    // Load animation using resource identifier to fix "Cannot resolve symbol" error
                    Animation bounceAnimation;
                    try {
                        // First attempt with direct reference
                        bounceAnimation = AnimationUtils.loadAnimation(context, R.anim.bounce_animation);
                    } catch (Exception e) {
                        // Fallback using resource identifier if direct reference fails
                        bounceAnimation = AnimationUtils.loadAnimation(context,
                                context.getResources().getIdentifier("bounce_animation", "anim", context.getPackageName()));
                    }

                    // Apply animation to each view
                    holder.emailTextView.setVisibility(View.VISIBLE);
                    holder.emailTextView.startAnimation(bounceAnimation);

                    holder.contactTextView.setVisibility(View.VISIBLE);
                    holder.contactTextView.startAnimation(bounceAnimation);

                    holder.coordinatorTextView.setVisibility(View.VISIBLE);
                    holder.coordinatorTextView.startAnimation(bounceAnimation);

                    holder.yearTextView.setVisibility(View.VISIBLE);
                    holder.yearTextView.startAnimation(bounceAnimation);

                    holder.responsibilityTextView.setVisibility(View.VISIBLE);
                    holder.responsibilityTextView.startAnimation(bounceAnimation);

                    holder.venueTextView.setVisibility(View.VISIBLE);
                    holder.venueTextView.startAnimation(bounceAnimation);

                    holder.blockTextView.setVisibility(View.VISIBLE);
                    holder.blockTextView.startAnimation(bounceAnimation);

                    // Update expand icon if it exists
                    if (holder.expandIcon != null) {
                        holder.expandIcon.setImageResource(R.drawable.ic_expanded_less);
                    }
                } else {
                    // Collapse all views
                    holder.emailTextView.setVisibility(View.GONE);
                    holder.contactTextView.setVisibility(View.GONE);
                    holder.coordinatorTextView.setVisibility(View.GONE);
                    holder.yearTextView.setVisibility(View.GONE);
                    holder.responsibilityTextView.setVisibility(View.GONE);
                    holder.venueTextView.setVisibility(View.GONE);
                    holder.blockTextView.setVisibility(View.GONE);

                    // Update expand icon if it exists
                    if (holder.expandIcon != null) {
                        holder.expandIcon.setImageResource(R.drawable.ic_expanded_more);
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return facultyList != null ? facultyList.size() : 0;
    }

    public void updateData(List<Faculty> newList) {
        if (newList == null) return;
        facultyList.clear();
        facultyList.addAll(newList);
        expandedItems.clear(); // Reset expanded states
        notifyDataSetChanged();
    }

    private String safeText(String input) {
        return input != null && !input.trim().isEmpty() ? input : "N/A";
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View cardContainer;
        TextView nameTextView, ecodeTextView, emailTextView, contactTextView,
                coordinatorTextView, yearTextView, responsibilityTextView,
                venueTextView, blockTextView;
        ImageView expandIcon; // Optional, may be null

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Find your existing views
            cardContainer = itemView; // or find a specific container view
            nameTextView = itemView.findViewById(R.id.nameTextView);
            ecodeTextView = itemView.findViewById(R.id.ecodeTextView);
            emailTextView = itemView.findViewById(R.id.emailTextView);
            contactTextView = itemView.findViewById(R.id.contactTextView);
            coordinatorTextView = itemView.findViewById(R.id.coordinatorTextView);
            yearTextView = itemView.findViewById(R.id.yearTextView);
            responsibilityTextView = itemView.findViewById(R.id.responsibilityTextView);
            venueTextView = itemView.findViewById(R.id.venueTextView);
            blockTextView = itemView.findViewById(R.id.blockTextView);

            // Try to find the expand icon (optional)
            try {
                expandIcon = itemView.findViewById(R.id.expandIcon);
            } catch (Exception e) {
                expandIcon = null; // It's okay if the icon doesn't exist
            }
        }
    }
}