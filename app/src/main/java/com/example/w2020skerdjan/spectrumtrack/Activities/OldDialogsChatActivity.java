package com.example.w2020skerdjan.spectrumtrack.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.w2020skerdjan.spectrumtrack.ChatFunctionality.ChatModels.Dialog;
import com.example.w2020skerdjan.spectrumtrack.ChatFunctionality.ChatModels.Message;
import com.example.w2020skerdjan.spectrumtrack.ChatFunctionality.DemoDialogsActivity;
import com.example.w2020skerdjan.spectrumtrack.ChatFunctionality.DialogsFixtures;
import com.example.w2020skerdjan.spectrumtrack.R;
import com.stfalcon.chatkit.dialogs.DialogsList;
import com.stfalcon.chatkit.dialogs.DialogsListAdapter;

import java.util.ArrayList;

/**
 * Created by W2020 Android on 11/20/2017.
 */

public class OldDialogsChatActivity extends DemoDialogsActivity {


        private  ActionBar actionBar;
        private  ArrayList<Dialog> dialogs;
        private  DialogsList dialogsList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.old_chat);
        dialogsList = (DialogsList) findViewById(R.id.dialogs);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        initAdapter();
    }


    @Override
    public void onDialogClick(Dialog dialog) {
        Toast.makeText(this, "Mesazhi nuk ekziston!", Toast.LENGTH_SHORT).show();
    }

    private void initAdapter() {
        super.dialogsAdapter = new DialogsListAdapter<>(super.imageLoader);
        super.dialogsAdapter.setItems(DialogsFixtures.getDialogs());
        super.dialogsAdapter.setOnDialogClickListener(this);
        super.dialogsAdapter.setOnDialogLongClickListener(this);
        dialogsList.setAdapter(super.dialogsAdapter);
    }


    private void onNewMessage(String dialogId, Message message) {
        boolean isUpdated = dialogsAdapter.updateDialogWithMessage(dialogId, message);
        if (!isUpdated) {
            //Dialog with this ID doesn't exist, so you can create new Dialog or update all dialogs list
        }
    }

    //for example
    private void onNewDialog(Dialog dialog) {
        dialogsAdapter.addItem(dialog);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;
        }

        return true;
    }
}
