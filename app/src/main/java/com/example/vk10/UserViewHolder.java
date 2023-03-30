package com.example.vk10;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView name, email, degreeType, completedDegrees;


    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.textName);
        email = itemView.findViewById(R.id.textEmail);
        degreeType = itemView.findViewById(R.id.textDegreeType);
        completedDegrees = itemView.findViewById(R.id.textCompletedDegrees);
    }
}
