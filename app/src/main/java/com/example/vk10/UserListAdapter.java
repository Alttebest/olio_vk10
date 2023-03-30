package com.example.vk10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private Context context;
    private ArrayList<User> users = new ArrayList<>();

    public UserListAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(context).inflate(R.layout.user_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.name.setText(users.get(position).getFirstName() + " " + users.get(position).getLastName());
        holder.email.setText(users.get(position).getEmail());
        holder.degreeType.setText(users.get(position).getDegreeProgram());
        if (users.get(position).getCompletedDegrees().isEmpty()){
            holder.completedDegrees.setVisibility(View.GONE);
        } else {
            for (String degree : users.get(position).getCompletedDegrees()){
                if (! degree.isEmpty()){
                    holder.completedDegrees.append("\n" + degree);
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
