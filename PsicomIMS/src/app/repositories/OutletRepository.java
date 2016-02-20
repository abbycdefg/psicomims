package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Outlet;

@Repository
public interface OutletRepository extends JpaRepository<Outlet, Long> 
{
	public Outlet findByOutletId(String outletId);
	public Outlet findById(Long id);
}