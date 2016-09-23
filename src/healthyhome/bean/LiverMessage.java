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
@Table(name = "liver_message")
public class LiverMessage extends BaseEntity {
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
	public LiverMessage(Integer id) {
		this.id = id;
	}
	public LiverMessage() {
	}
	@Column(name="date")
	private String date;
	@Column(name = "uid")
	private int uid;
	@Column(name = "liver")
	private String liver;
	@Column(name = "liver_inspector")
	private String liverInspector;
	@Column(name = "times")
	private int times;
	@Column(name = "comment")
	private String comment;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
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
	public String getLiver() {
		return liver;
	}
	public void setLiver(String liver) {
		this.liver = liver;
	}
	public String getLiverInspector() {
		return liverInspector;
	}
	public void setLiverInspector(String liverInspector) {
		this.liverInspector = liverInspector;
	}
}
