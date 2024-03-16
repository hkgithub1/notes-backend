package net.hkapp.notes.dao;

import net.hkapp.notes.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteDao extends JpaRepository<Note, Integer> {
    @Query(value="SELECT * FROM storedb.notes_table WHERE content LIKE %?1%", nativeQuery=true)
    List<Note> findByContent(String query);
}
