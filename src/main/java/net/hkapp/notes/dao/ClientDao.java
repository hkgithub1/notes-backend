package net.hkapp.notes.dao;

import net.hkapp.notes.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<Client, Integer> {
}
