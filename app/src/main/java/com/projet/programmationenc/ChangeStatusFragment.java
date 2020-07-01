package com.projet.programmationenc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChangeStatusFragment extends Fragment {
    private TextInputLayout edtchangestatus;
    private Button btnchangestatus;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_changestatus,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((HomeActivity) getActivity()).getSupportActionBar().setTitle("Changement du status");
        ((HomeActivity) getActivity()).ShowBackButton(true);
        ((HomeActivity) getActivity()).bottomNavigationView.setVisibility(View.GONE);

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        edtchangestatus = view.findViewById(R.id.edtchangestatus);
        btnchangestatus = view.findViewById(R.id.btnchangestatus);

        String status = getArguments().getString("status");
        edtchangestatus.getEditText().setText(status);

        btnchangestatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String statusChanged = edtchangestatus.getEditText().getText().toString();

                if(statusChanged.isEmpty()) {
                    edtchangestatus.setError("Veuillez saisir votre status");
                }
                else if(statusChanged.equals(status)) {
                    return;
                }
                else {
                    databaseReference.child("Students").child(user.getUid()).child("status").setValue(statusChanged).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()) {
                                Toast.makeText(getActivity(), "Changement réussi du status !", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
