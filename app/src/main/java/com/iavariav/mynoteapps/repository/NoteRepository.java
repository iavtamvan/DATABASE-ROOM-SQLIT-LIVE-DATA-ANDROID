package com.iavariav.mynoteapps.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;

import com.iavariav.mynoteapps.database.Note;
import com.iavariav.mynoteapps.database.NoteDao;
import com.iavariav.mynoteapps.database.NoteRoomDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoteRepository {
    private NoteDao mNotesDao;
    private ExecutorService executorService;
    public NoteRepository(Application application) {
        executorService = Executors.newSingleThreadExecutor();

        NoteRoomDatabase db = NoteRoomDatabase.getDatabase(application);
        mNotesDao = db.noteDao();
    }

    public DataSource.Factory<Integer, Note> getAllNotes() {
        return mNotesDao.getAllNotes();
    }

    public void insert(final Note note) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                mNotesDao.insert(note);
            }
        });
    }

    public void delete(final Note note){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                mNotesDao.delete(note);
            }
        });
    }

    public void update(final Note note){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                mNotesDao.update(note);
            }
        });
    }
}
