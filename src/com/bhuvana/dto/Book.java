package com.bhuvana.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class Book {
	@Id	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bookId;
	
	private String bookName;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name = "Book_address",
		joinColumns=@JoinColumn(name="book_id"))
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = { @Column(name="address_id") }, generator = "hilo-gen", type = @Type(type="long"))
	private Collection<Address> listOfAdd = new ArrayList<Address>();
		
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Collection<Address> getListOfAdd() {
		return listOfAdd;
	}
	public void setListOfAdd(Collection<Address> listOfAdd) {
		this.listOfAdd = listOfAdd;
	}
}