package com.example.permisosmapas;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cursoradapter.widget.CursorAdapter;

public class ContactsAdapter extends CursorAdapter {
    private static final int CONTACT_ID_INDEX = 0;
    private static final int DISPLAY_NAME_INDEX = 1;

    ContactsAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.contacts, parent, false);
    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvIdContacto = view.findViewById(R.id.idContact);
        TextView tvNombre = view.findViewById(R.id.nameContact);
        int idnum = cursor.getInt(CONTACT_ID_INDEX);
        String nombre = cursor.getString(DISPLAY_NAME_INDEX);
        tvIdContacto.setText(String.valueOf(idnum));
        tvNombre.setText(nombre);
    }
}
