package com.noshairx.statusupdating.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.noshairx.statusupdating.ModelClasses.ModelClass;
import com.noshairx.statusupdating.R;

public class FBAdapter extends FirestoreRecyclerAdapter<ModelClass, FBAdapter.FbViewHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public FBAdapter(@NonNull FirestoreRecyclerOptions<ModelClass> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull FbViewHolder holder, int position, @NonNull ModelClass model) {

        String userName=getSnapshots().getSnapshot(position).getId();
        holder.userNameTV.setText(userName);
        holder.userStatusTV.setText(model.getStatus());

    }

    @NonNull
    @Override
    public FbViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new FbViewHolder(LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.single_row,viewGroup,false)
        );

    }

    public class FbViewHolder extends RecyclerView.ViewHolder
    {

          TextView userNameTV, userStatusTV;
        public FbViewHolder(@NonNull View singlerow) {
            super(singlerow);
            userNameTV=singlerow.findViewById(R.id.sr_username);
            userStatusTV=singlerow.findViewById(R.id.sr_userStatus);

        }
    }

}
