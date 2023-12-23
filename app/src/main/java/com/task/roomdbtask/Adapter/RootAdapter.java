package com.task.roomdbtask.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.task.roomdbtask.R;
import com.task.roomdbtask.model.Root;

import java.util.List;

public class RootAdapter extends RecyclerView.Adapter<RootAdapter.RootViewHolder> {

    private Context context;
    private List<Root> rootList;

    public RootAdapter(Context context, List<Root> rootList) {
        this.context = context;
        this.rootList = rootList;
    }

    @NonNull
    @Override
    public RootViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RootViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.root_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RootViewHolder holder, int position) {

        Root root=rootList.get(position);
        holder.id.setText("id : " +root.getId());
        holder.title.setText("title : " +root.getTitle());
        holder.price.setText("price : " +root.getPrice());
        holder.description.setText("description : " +root.getDescription());
        holder.category.setText("category : " +root.getCategory());
        holder.rating.setText("rating : "+root.getRating());


        Glide.with(context)
                .load(root.getImage())
                .into(holder.image);

    }

    public void getAllRoots(List<Root>rootList)
    {
        this.rootList = rootList;
    }

    @Override
    public int getItemCount() {
        return rootList.size();
    }

    public static class RootViewHolder extends RecyclerView{
        public TextView id,title,price,description,category,rating;
        public  ImageView image;
        public RootViewHolder (@NonNull View itemView){
     super(itemView);

            id=itemView.findViewById(R.id.id);
            title=itemView.findViewById(R.id.title);
            price=itemView.findViewById(R.id.price);
            description=itemView.findViewById(R.id.description);
            category=itemView.findViewById(R.id.category);
            rating=itemView.findViewById(R.id.rating);
            image=itemView.findViewById(R.id.poster);

        }
    }
}
