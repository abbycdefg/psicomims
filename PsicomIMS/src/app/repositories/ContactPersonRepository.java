package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.ContactPerson;

@Repository
public interface ContactPersonRepository extends JpaRepository<ContactPerson, Long> 
{
	public ContactPerson findByContactPersonId(Long contactPersonId);
	public ContactPerson findByContactPersonName(String contactPersonName);
}
