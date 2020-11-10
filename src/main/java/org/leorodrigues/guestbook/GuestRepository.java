package org.leorodrigues.guestbook;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "guests", path = "guests")
public interface GuestRepository extends MongoRepository<Guest, String> {
    List<Guest> findAll();
}