package healthyhome.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "external_message")
public class ExternalMessage extends BaseEntity{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//GenerationType.IDENTITY
	@Column(name = "id")
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public ExternalMessage() {
	}
	public ExternalMessage(Integer id) {
		this.id = id;
	}
	@Column(name = "uid")
	private int uid;
	@Column(name = "height")
	private int height;
	@Column(name = "weight")
	private int weight;
	@Column(name = "skin")
	private String skin;
	@Column(name = "extremities_and_spine")
	private String extremitiesAndSpine;
	@Column(name = "others")
	private String others;
	@Column(name = "external_inspector")
	private String externalInspector;
	@Column(name="date")
	private String date;
	@Column(name = "comment")
	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getSkin() {
		return skin;
	}
	public void setSkin(String skin) {
		this.skin = skin;
	}
	public String getExtremitiesAndSpine() {
		return extremitiesAndSpine;
	}
	public void setExtremitiesAndSpine(String extremitiesAndSpine) {
		this.extremitiesAndSpine = extremitiesAndSpine;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public String getExternalInspector() {
		return externalInspector;
	}
	public void setExternalInspector(String externalInspector) {
		this.externalInspector = externalInspector;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
