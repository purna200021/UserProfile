package com.profile.demoprofile.model;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="address")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  addressId;
	private String addressLine1,addressLine2,city,state,country,zipCode;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumns({
		@JoinColumn(name="cust_FirstName",referencedColumnName ="firstName"),
		@JoinColumn(name="cust_LastName",referencedColumnName ="lastName" )
		
	})
	@JsonBackReference
    private Profile profile;

}
