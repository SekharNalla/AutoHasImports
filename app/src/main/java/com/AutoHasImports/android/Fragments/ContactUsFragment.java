package com.AutoHasImports.android.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.AutoHasImports.android.AutoHasSharedPreferences;
import com.AutoHasImports.android.Constants.ActivityTitles;
import com.AutoHasImports.android.R;

import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;

/**
 * Created by Sekhar on 8/10/14.
 */

public class ContactUsFragment extends RoboFragment {

    private Activity _activity;

    @InjectView (R.id.send_button) Button _sendButton;

    @InjectView (R.id.first_name) EditText _firstNameEditText;

    @InjectView (R.id.last_name) EditText _lastNameEditText;

    @InjectView (R.id.city) EditText _cityEditText;

    @InjectView (R.id.state) EditText _stateEditText;

    @InjectView (R.id.phone_number) EditText _phoneNumberEditText;

    @InjectView (R.id.email) EditText _emailEditText;

    public ContactUsFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.contact_us_fragment, container, false);


        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        _activity = activity;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        _firstNameEditText.setText(AutoHasSharedPreferences.getFirstName());
        _lastNameEditText.setText(AutoHasSharedPreferences.getLastName());
        _cityEditText.setText(AutoHasSharedPreferences.getCity());
        _stateEditText.setText(AutoHasSharedPreferences.getState());
        _phoneNumberEditText.setText(AutoHasSharedPreferences.getPhoneNumber());
        _emailEditText.setText(AutoHasSharedPreferences.getEmail());

        _sendButton.setOnClickListener(new SendButtonClickListener());

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if ( _activity != null ) {
            _activity.getActionBar().setTitle(ActivityTitles.CONTACT_US.toString());
        }
    }

    private class SendButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            AutoHasSharedPreferences.setFirstName(_firstNameEditText.getText().toString());
            AutoHasSharedPreferences.setLastName(_lastNameEditText.getText().toString());
            AutoHasSharedPreferences.setCity(_cityEditText.getText().toString());
            AutoHasSharedPreferences.setState(_stateEditText.getText().toString());
            AutoHasSharedPreferences.setPhoneNumber(_phoneNumberEditText.getText().toString());
            AutoHasSharedPreferences.setEmail(_emailEditText.getText().toString());
        }
    }
}
