package com.aakash.vendor.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aakash.vendor.entities.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {

}
