package com.example.w2020skerdjan.spectrumtrack.ChatFunctionality;



import com.example.w2020skerdjan.spectrumtrack.ChatFunctionality.ChatModels.Dialog;
import com.example.w2020skerdjan.spectrumtrack.ChatFunctionality.ChatModels.Message;
import com.example.w2020skerdjan.spectrumtrack.ChatFunctionality.ChatModels.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by W2020 Android on 11/21/2017.
 */

public final class DialogsFixtures extends FixturesData {

    private ArrayList<User> hardCodedUsers =  new ArrayList<>();
    private DialogsFixtures() {
        throw new AssertionError();
    }

    public static ArrayList<Dialog> getDialogs() {
        ArrayList<Dialog> chats = new ArrayList<>();

        for (int i = 0; i <8; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, -(i * i));
            calendar.add(Calendar.MINUTE, -(i * i));
            chats.add(getDialog(i, calendar.getTime()));
        }
        return chats;
    }

    private static Dialog getDialog(int i, Date lastMessageCreatedAt) {
        ArrayList<User> users = getUsers();
        return new Dialog(
                getRandomId(),
                users.get(rnd.nextInt(3)).getName(),
                getRandomAvatar(),
                users,
                getMessage(lastMessageCreatedAt),
                i < 3 ? 3 - i : 0);
    }

    private static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();

            users.add(new User("1","Skerdjan Gurabardhi", "https://scontent.fskg1-1.fna.fbcdn.net/v/t1.0-1/p160x160/16681667_1378333725550492_7645852226125849371_n.jpg?oh=9c46457513d78ec4a9e89380872f6827&oe=5AA51006", true));
            users.add(new User("2","Ersi Musta", "https://scontent.fskg1-1.fna.fbcdn.net/v/t31.0-8/16797287_1214827481905370_1452615798237214871_o.jpg?oh=2e22233f0800605ed04d6ae0f2fa49d6&oe=5AA41B5F", true));
            users.add(new User("3","Besnik Palluqi", "https://scontent.fskg1-1.fna.fbcdn.net/v/t1.0-1/p160x160/10258009_887102014687854_1551946744427834665_n.jpg?oh=c305811285ce35d72f5ea55c00306399&oe=5AA22850", false));
            users.add(new User("4","Artion Hasani", "https://scontent.fskg1-1.fna.fbcdn.net/v/t1.0-1/p160x160/10653551_4807371799521_3073438902636464705_n.jpg?oh=fd4ea1e36fd9e0f80205cbb3cf714f67&oe=5AA537B0", false));
            int usersCount = users.size();
        return users;
    }

    private static User getUser(int i) {
        return getUsers().get(i);
    }

    private static Message getMessage(final Date date) {
        return new Message(
                getRandomId(),
                getUser(rnd.nextInt(3)),
                getRandomMessage(),
                date);


    }
}
