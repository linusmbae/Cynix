package com.linus.cynix.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.linus.cynix.Constants;
import com.linus.cynix.R;
import com.linus.cynix.adapter.CynixFirebaseViewHolder;
import com.linus.cynix.models.AvailableShops;
import com.linus.cynix.models.Shops;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedShops extends AppCompatActivity {

    private DatabaseReference mShopsReference;
    private FirebaseRecyclerAdapter<Shops, CynixFirebaseViewHolder> mFirebaseAdapter;

    @BindView(R.id.recyclerView)RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);
        ButterKnife.bind(this);

        mShopsReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_SHOPS);
        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter() {
        FirebaseRecyclerOptions<Shops> options =
                new FirebaseRecyclerOptions.Builder<Shops>()
                        .setQuery(mShopsReference, Shops.class)
                        .build();
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Shops, CynixFirebaseViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull CynixFirebaseViewHolder firebaseRestaurantViewHolder, int position, @NonNull Shops shop) {
                firebaseRestaurantViewHolder.bindShop(shop);
            }

            @NonNull
            @Override
            public CynixFirebaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_list_item, parent, false);
                return new CynixFirebaseViewHolder(view);
            }
        };

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }
}