package com.example.volkeee.mmotpotdooagp.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.volkeee.mmotpotdooagp.R;
import com.example.volkeee.mmotpotdooagp.utils.Calculations;
import com.example.volkeee.mmotpotdooagp.utils.OnFragmentInteractionListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class Lab1Fragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private TextInputEditText editTextStartofArray;
    private TextInputEditText editTextEndofArray;
    private TextInputEditText editTextAccuracy;
    private TextInputEditText editTextStep;
    private GraphView mainGraphView;

    public Lab1Fragment() {
        // Required empty public constructor
    }

    public static Lab1Fragment newInstance() {
        Lab1Fragment fragment = new Lab1Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_lab_1, container, false);
        mainGraphView = inflatedView.findViewById(R.id.graphView);

        editTextStartofArray = inflatedView.findViewById(R.id.textInputEditText_start_of_array);
        editTextEndofArray = inflatedView.findViewById(R.id.textInputEditText_end_of_array);
        editTextAccuracy = inflatedView.findViewById(R.id.textInputEditText_accuracy);
        editTextStep = inflatedView.findViewById(R.id.textInputEditText_step);


        editTextStartofArray.setText("-10.0");
        editTextEndofArray.setText("10.0");
        editTextStep.setEnabled(false);
        editTextAccuracy.setText("0.0001");
        return inflatedView;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
            Log.d("Result is: ", Calculations.calculateLinearEquation(-10.0, 10.0, 0.001, parameter -> Math.log(parameter) - 5 + parameter).toString());
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
