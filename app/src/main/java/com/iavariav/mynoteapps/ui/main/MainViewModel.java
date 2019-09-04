package com.iavariav.mynoteapps.ui.main;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.iavariav.mynoteapps.database.Note;
import com.iavariav.mynoteapps.repository.NoteRepository;

import java.util.List;

public class MainViewModel extends ViewModel {
    private NoteRepository mNoteRepository;

    public MainViewModel(Application application) {
        mNoteRepository = new NoteRepository(application);
    }

    public LiveData<List<Note>> getAllNotes() {
        return mNoteRepository.getAllNotes();
    }
}
