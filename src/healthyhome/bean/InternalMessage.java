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
@Table(name = "internal_messsage")
public class InternalMessage extends BaseEntity{
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
	public InternalMessage() {
	}
	public InternalMessage(Integer id) {
		this.id = id;
	}
	
	@Column(name = "uid")
	private int uid;
	@Column(name = "blood_pressure")
	private String bloodPressure;
	@Column(name = "heart_and_lung")
	private String heartAndLung;
	@Column(name = "interal_inspector")
	private String internalInspector;
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
	public String getBloodPressure() {
		return bloodPressure;
	}
	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	public String getHeartAndLung() {
		return heartAndLung;
	}
	public void setHeartAndLung(String heartAndLung) {
		this.heartAndLung = heartAndLung;
	}
	public String getInternalInspector() {
		return internalInspector;
	}
	public void setInternalInspector(String internalInspector) {
		this.internalInspector = internalInspector;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}