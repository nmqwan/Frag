package com.amely.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.amely.myapplication.R;
import com.amely.myapplication.SetOnChangeFragmentListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button btnA, btnAdd;
    TextView txt;
    View v;
    SetOnChangeFragmentListener listener;

    public AFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AFragment newInstance() {
        AFragment fragment = new AFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_a, container, false);
        initData();
        return v;
    }

    private void initData() {
        btnA = v.findViewById(R.id.btnA);
        btnAdd = v.findViewById(R.id.btnAdd);
        txt = v.findViewById(R.id.txtA);
        listener = (SetOnChangeFragmentListener) getActivity();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(txt.getText().toString());
                i = i + 1;
                txt.setText(i + "");
            }
        });
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onChangeListener(1);
            }
        });
    }

}
