package com.login.chayo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

public class BDconexion extends SQLiteOpenHelper {

    // Nombre de la base de datos y versión
    private static final String DATABASE_NAME = "mi_tienda.db";
    private static final int DATABASE_VERSION = 1;

    // Tabla de usuario
    private static final String COL_USERNAME = "username";
    private static final String COL_PASSWORD = "password";

    // Tablas
    public static final String TABLE_PRODUCTS = "products";
    public static final String TABLE_CLIENTS = "clients";

    // Columnas de la tabla de productos
    public static final String COLUMN_PRODUCT_ID = "id";
    public static final String COLUMN_PRODUCT_NAME = "name";
    public static final String COLUMN_PRODUCT_QUANTITY = "quantity";

    // Columnas de la tabla de clientes
    public static final String COLUMN_CLIENT_ID = "id";
    public static final String COLUMN_CLIENT_NAME = "name";
    public static final String COLUMN_CLIENT_PHONE = "phone";

    // Sentencias SQL para crear las tablas
    private static final String CREATE_TABLE_PRODUCTS =
            "CREATE TABLE " + TABLE_PRODUCTS + " (" +
                    COLUMN_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_PRODUCT_NAME + " TEXT NOT NULL, " +
                    COLUMN_PRODUCT_QUANTITY + " INTEGER NOT NULL);";

    private static final String CREATE_TABLE_CLIENTS =
            "CREATE TABLE " + TABLE_CLIENTS + " (" +
                    COLUMN_CLIENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_CLIENT_NAME + " TEXT NOT NULL, " +
                    COLUMN_CLIENT_PHONE + " TEXT NOT NULL);";

    public BDconexion(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear las tablas
        db.execSQL(CREATE_TABLE_PRODUCTS);
        db.execSQL(CREATE_TABLE_CLIENTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Eliminar tablas existentes si la base de datos es actualizada
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENTS);
        onCreate(db);
    }

    // Métodos CRUD para productos
    public long insertProduct(String name, int quantity) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCT_NAME, name);
        values.put(COLUMN_PRODUCT_QUANTITY, quantity);
        return db.insert(TABLE_PRODUCTS, null, values);
    }

    public Cursor getAllProducts() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_PRODUCTS, null);
    }

    public void deleteProduct(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PRODUCTS, COLUMN_PRODUCT_ID + "=?", new String[]{String.valueOf(id)});
    }

    // Métodos CRUD para clientes
    public long insertClient(String name, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CLIENT_NAME, name);
        values.put(COLUMN_CLIENT_PHONE, phone);
        return db.insert(TABLE_CLIENTS, null, values);
    }

    public Cursor getAllClients() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_CLIENTS, null);
    }

    public void deleteClient(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CLIENTS, COLUMN_CLIENT_ID + "=?", new String[]{String.valueOf(id)});
    }
}
