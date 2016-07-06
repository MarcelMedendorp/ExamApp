package nl.programit.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Category implements Serializable {
	private static final long serialVersionUID = 1692795382720751242L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryID;
	

	@ManyToOne
	@JoinColumn(name = "question")
	private List<Question> questions;
}
