package com.example.traveling_app.common;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseReferences {
    private static final FirebaseDatabase INSTANCE = FirebaseDatabase.getInstance();
    public static final DatabaseReference USER_DATABASE_REF = INSTANCE.getReference("/users");
    public static final DatabaseReference POST_DATABASE_REF = INSTANCE.getReference("/posts");
    public static final DatabaseReference TOURS_DATABASE_REF = INSTANCE.getReference("/tours");
    public static final DatabaseReference USER_SAVED_TOURS_DATABASE_REF = INSTANCE.getReference("/saved_tours");

}
