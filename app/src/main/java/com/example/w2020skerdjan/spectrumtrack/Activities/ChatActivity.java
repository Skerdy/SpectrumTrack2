package com.example.w2020skerdjan.spectrumtrack.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;

import com.example.w2020skerdjan.spectrumtrack.ChatFunctionality.AppUtils;
import com.example.w2020skerdjan.spectrumtrack.ChatFunctionality.BaseChatActivity;
import com.example.w2020skerdjan.spectrumtrack.ChatFunctionality.ChatModels.Message;
import com.example.w2020skerdjan.spectrumtrack.ChatFunctionality.MessagesFixtures;
import com.example.w2020skerdjan.spectrumtrack.R;
import com.stfalcon.chatkit.messages.MessageInput;
import com.stfalcon.chatkit.messages.MessagesList;
import com.stfalcon.chatkit.messages.MessagesListAdapter;

/**
 * Created by W2020 Android on 12/8/2017.
 */

public class ChatActivity extends BaseChatActivity implements MessageInput.InputListener,
        MessageInput.AttachmentsListener {

    private ActionBar actionBar;


    public static void open(Context context) {
        context.startActivity(new Intent(context, ChatActivity.class));
    }

    private MessagesList messagesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_activity);

        this.messagesList = (MessagesList) findViewById(R.id.messagesList);
        initAdapter();

        MessageInput input = (MessageInput) findViewById(R.id.input);
        input.setInputListener(this);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSubmit(CharSequence input) {
        super.messagesAdapter.addToStart(
                MessagesFixtures.getTextMessage(input.toString()), true);
        return true;
    }

    @Override
    public void onAddAttachments() {
        super.messagesAdapter.addToStart(
                MessagesFixtures.getImageMessage(), true);
    }

    private void initAdapter() {
        super.messagesAdapter = new MessagesListAdapter<>(super.senderId, super.imageLoader);
        super.messagesAdapter.enableSelectionMode(this);
        super.messagesAdapter.setLoadMoreListener(this);
        super.messagesAdapter.registerViewClickListener(R.id.messageUserAvatar,
                new MessagesListAdapter.OnMessageViewClickListener<Message>() {
                    @Override
                    public void onMessageViewClick(View view, Message message) {
                        AppUtils.showToast(ChatActivity.this,
                                message.getUser().getName() + " clicked",
                                false);
                    }
                });
        this.messagesList.setAdapter(super.messagesAdapter);
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
