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
@Table(name = "ear_message")
public class EarMessage extends BaseEntity{
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
	
	public EarMessage() {
	}
	public EarMessage(Integer id) {
		this.id = id;
	}
	@Column(name = "left_ear")
	private String leftEar;
	@Column(name = "right_ear")
	private String rightEar;
	@Column(name = "ear_inspector")
	private String earInspector;
	@Column(name="date")
	private String date;
	@Column(name = "uid")
	private int uid;
	@Column(name = "comment")
	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getLeftEar() {
		return leftEar;
	}
	public void setLeftEar(String leftEar) {
		this.leftEar = leftEar;
	}
	public String getRightEar() {
		return rightEar;
	}
	public void setRightEar(String rightEar) {
		this.rightEar = rightEar;
	}
	public String getEarInspector() {
		return earInspector;
	}
	public void setEarInspector(String earInspector) {
		this.earInspector = earInspector;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
}
