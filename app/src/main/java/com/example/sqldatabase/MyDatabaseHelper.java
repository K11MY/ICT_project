package com.example.sqldatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "BOSS.db";
    public static final Integer DATABASE_VERSION = 1;

    public static final String PARTHAUTH_TABLE = "PARTHAUTH_TABLE";
    public static final String COLUMN_RANGER_ID = "RANGER_ID";
    public static final String COLUMN_RANGER_PARKID = "RANGER_PARKID";

    // USER
    // Define user column
    public static final String USERID_TABLE = "USERID_TABLE";
    public static final String COLUMN_USER_ID = "USER_ID";
    public static final String COLUMN_USER_TYPE = "USER_TYPE";
    // Create user table
    public static final String CREATE_USERID_TABLE = "CREATE TABLE " + USERID_TABLE + " (" +
            COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_USER_TYPE + " TEXT);";

    // BUSHWALKER
    // Define Bushwalker columns
    public static final String COLUMN_WALKER_NAME = "WALKER_NAME";
    public static final String COLUMN_WALKER_PHONE = "WALKER_PHONE";
    public static final String COLUMN_WALKER_EMAIL = "WALKER_EMAIL";
    public static final String COLUMN_MEDICAL_INFO = "SPECIAL_INFO";
    public static final String COLUMN_WALKER_ID = "WALKER_ID";
    public static final String BUSHWALKER_TABLE = "BUSHWALKER_TABLE";
    public static final String COLUMN_EMERGENCY_CONTACT = "EMERGENCY_CONTACT";
    // Create bushwalker table
    public static final String CREATE_BUSHWALKER_TABLE = "CREATE TABLE " + BUSHWALKER_TABLE + " (" +
            COLUMN_WALKER_ID + " INTEGER," +
            COLUMN_WALKER_NAME + "TEXT," +
            COLUMN_WALKER_PHONE + " BIGINT," +
            COLUMN_EMERGENCY_CONTACT + " BIGINT," +
            COLUMN_WALKER_EMAIL + " TEXT," +
            COLUMN_MEDICAL_INFO + " BLOB," +
            "FOREIGN KEY ("+COLUMN_WALKER_ID+") REFERENCES "+USERID_TABLE+"("+COLUMN_USER_ID+"));";


    // RANGER
    // Define ranger columns
    public static final String COLUMN_PARK_ID = "PARK_ID";
    private static final String COLUMN_RANGER_NAME = "RANGER_NAME";
    // Create ranger table
    public static final String CREATE_PARKAUTH_TABLE = "CREATE TABLE " + PARTHAUTH_TABLE + " ( " +
            COLUMN_RANGER_ID + " INTEGER," +
            COLUMN_RANGER_PARKID + " INTEGER," +
            COLUMN_RANGER_NAME +" TEXT," +
            "FOREIGN KEY ("+COLUMN_RANGER_ID+") REFERENCES "+USERID_TABLE+"("+COLUMN_USER_ID+"));";


    public static final String COLUMN_PASSWORD_ID = "PASSWORD_ID";
    public static final String PASSWORD_TABLE = "PASSWORD_TABLE";
    public static final String COLUMN_USER_PWID = "COLUMN_USER_PWID";
    public static final String COLUMN_PASSWORD = "COLUMN_PASSWORD";
    // PASSWORD
    // Define password columns
    public static final String CREATE_PASSWORD_TABLE = "CREATE TABLE " + PASSWORD_TABLE + " (" +
            COLUMN_PASSWORD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_USER_PWID + " INTEGER," +
            COLUMN_PASSWORD + " BLOB," +
            "FOREIGN KEY ("+COLUMN_USER_PWID+") REFERENCES "+USERID_TABLE+"("+COLUMN_USER_ID+"));";
    // PARK
    // Define Park Columns
    public static final String COLUMN_PARK_CORDS = "PARK_CORDS";
    public static final String COLUMN_IMAGE = "IMAGE";
    public static final String COLUMN_ADDRESS = "ADDRESS";
    public static final String PARK_TABLE = "PARK_TABLE";
    // Create Park table
    public static final String CREATE_PARK_TABLE = "CREATE TABLE " + PARK_TABLE + " (" +
            COLUMN_PARK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_PARK_CORDS + " BLOB," +
            COLUMN_IMAGE + " BLOB," +
            COLUMN_ADDRESS + " BLOB);";


    // TRAIL
    // Define Trail Columns
    public static final String COLUMN_TRAIL_ID = "TRAIL_ID";
    public static final String COLUMN_TRAIL_PARKID = "TRAIL_PARKID";
    public static final String COLUMN_TRAIL_CORDS = "TRAIL_CORDS";
    public static final String TRAILS_TABLE = "TRAILS_TABLE";
    // Create Trail Table
    public static final String CREATE_TRAIL_TABLE = "CREATE TABLE " + TRAILS_TABLE + " (" +
            COLUMN_TRAIL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_TRAIL_PARKID + " INT," +
            COLUMN_TRAIL_CORDS + " BLOB," +
            "FOREIGN KEY ("+COLUMN_TRAIL_PARKID+") REFERENCES "+PARK_TABLE+"("+COLUMN_PARK_ID+"));";

    // Registered Walks
    // Define Columns
    public static final String COLUMN_WALKID = "COLUMN_WALKID";
    public static final String COLUMN_TRAIL_TRAILID = "COLUMN_TRAIL_TRAILID";
    public static final String COLUMN_BW_ID = "COLUMN_BW_ID";
    public static final String REG_WALKS = "REG_WALKS";
    public static final String COLUMN_START_TIME = "COLUMN_START_TIME";
    public static final String COLUMN_GROUP_SIZE = "COLUMN_GROUP_SIZE";
    public static final String COLUMN_BW_EXPECTED_END_TIME = "COLUMN_BW_EXPECTED_END_TIME";
    public static final String COLUMN_SPECIAL_INFO = "COLUMN_SPECIAL_INFO";
    // Create Register Walks table
    public static final String CREATE_REGWALKS_TABLE = "CREATE TABLE " + REG_WALKS + " (" +
            COLUMN_WALKID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_TRAIL_TRAILID + " INT," +
            COLUMN_BW_ID + " INT," +
            COLUMN_START_TIME + " DATETIME," +
            COLUMN_GROUP_SIZE + " INT," +
            COLUMN_BW_EXPECTED_END_TIME + " DATETIME," +
            COLUMN_SPECIAL_INFO + " BLOB," +
            "FOREIGN KEY ("+COLUMN_BW_ID+") REFERENCES "+BUSHWALKER_TABLE+"("+COLUMN_WALKER_ID+")," +
            "FOREIGN KEY ("+COLUMN_TRAIL_TRAILID+") REFERENCES "+TRAILS_TABLE+"("+COLUMN_TRAIL_ID+"));";


    public static final String COMMENTS_TABLE = "COMMENTS";
    public static final String COLUMN_COMMENT = "COLUMN_COMMENT";
    public static final String COLUMN_COMMENT_ID = COLUMN_COMMENT + "_ID";
    public static final String COLUMN_COMMENT_WALKER_ID = COLUMN_COMMENT + "_WALKER_ID";
    public static final String COLUMN_TIMESTAMP = "COLUMN_TIMESTAMP";
    public static final String COLUMN_RATING = "COLUMN_RATING";
    public static final String CREATE_COMMENTS_TABLE = "CREATE TABLE " + COMMENTS_TABLE + " (" +
            COLUMN_COMMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_COMMENT_WALKER_ID + " INT," +
            COLUMN_TIMESTAMP + " DATETIME," +
            COLUMN_RATING + " INT," +
            COLUMN_COMMENT + " BLOB," +
            "FOREIGN KEY ("+COLUMN_COMMENT_WALKER_ID+") REFERENCES "+BUSHWALKER_TABLE+"("+COLUMN_WALKER_ID+"));";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Start User ID Table
        db.execSQL(CREATE_USERID_TABLE);
        // Create Bushwalker Table
        db.execSQL(CREATE_BUSHWALKER_TABLE);
        // Park Authority Table
        db.execSQL(CREATE_PARKAUTH_TABLE);
        // Password
        db.execSQL(CREATE_PASSWORD_TABLE);
        // Parks
        db.execSQL(CREATE_PARK_TABLE);
        // Trails
        db.execSQL(CREATE_TRAIL_TABLE);
        // Reg Walks
        db.execSQL(CREATE_REGWALKS_TABLE);
        // Comments
        db.execSQL(CREATE_COMMENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        // User ID
        db.execSQL("DROP TABLE IF EXISTS " + USERID_TABLE);
        // Bushwalker
        db.execSQL("DROP TABLE IF EXISTS " + BUSHWALKER_TABLE);
        // Park Auth (Rangers)
        db.execSQL("DROP TABLE IF EXISTS " + PARTHAUTH_TABLE);
        // Password
        db.execSQL("DROP TABLE IF EXISTS " + PASSWORD_TABLE);
        // Park
        db.execSQL("DROP TABLE IF EXISTS " + PARK_TABLE);
        // Trail
        db.execSQL("DROP TABLE IF EXISTS " + TRAILS_TABLE);
        // Registered Walks
        db.execSQL("DROP TABLE IF EXISTS " + REG_WALKS);
        // Comments
        db.execSQL("DROP TABLE IF EXISTS " + COMMENTS_TABLE);
        // Create Tables
        onCreate(db);
    }
}
