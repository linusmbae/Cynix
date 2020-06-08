package com.linus.cynix.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.linus.cynix.Constants;
import com.linus.cynix.R;
import com.linus.cynix.models.AvailableShops;
import com.linus.cynix.models.Shops;
import com.linus.cynix.ui.ShopsDetails;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;

public class CynixFirebaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View mView;
    Context mContext;

    public CynixFirebaseViewHolder(@NonNull View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindShop(Shops shops){
        ImageView shopImageView=(ImageView)mView.findViewById(R.id.shopImageView);
        TextView  shopName=(TextView)mView.findViewById(R.id.shopNameTextView);
        TextView shopFloor=(TextView)mView.findViewById(R.id.floorTextView);
        TextView shopBuildings=(TextView)mView.findViewById(R.id.buildingsTextView);
        TextView shopEmail=(TextView)mView.findViewById(R.id.emailTextView);

        Picasso.get().load(shops.getImage()).into(shopImageView);

        shopName.setText(shops.getName());
        shopFloor.setText(shops.getShopNumber());
        shopBuildings.setText(shops.getBuildingName());
        shopEmail.setText(shops.getEmail());
    }

    @Override
    public void onClick(View v) {
final ArrayList<AvailableShops>shops=new ArrayList<>();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        DatabaseReference ref= FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_SHOPS).child(uid);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                    shops.add(snapshot.getValue(AvailableShops.class));
                }
                int itemPosition = getLayoutPosition();
                Intent intent=new Intent(mContext, ShopsDetails.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("shops", Parcels.wrap(shops));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
